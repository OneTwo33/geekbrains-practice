package ru.onetwo33.practice.homework2;

import java.util.*;

public class LinkedList<T> implements List<T> {

    private Item<T> first = null;
    private Item<T> last = null;
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        for (Object item: this) {
            if (item.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = get(i);
        }
        return arr;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            final Object[] m = new Object[size];
            T1[] t1s = (T1[]) Arrays.copyOf(m, size, a.getClass());
            for (int i = 0; i < size; i++) {
                t1s[i] = (T1) get(i);
            }
            return t1s;
        }
        for (int i = 0; i < size; i++) {
            a[i] = (T1) get(i);
        }
        return a;
    }

    @Override
    public boolean add(final T t) {
        final Item<T> item = new Item<>(t, null, null);
        if (isEmpty()) {
            first = item;
        } else {
            item.prev = this.last;
            this.last.next = item;
        }
        last = item;
        size++;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        Item<T> current = first;
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(o)) {
                if (i == 0) {
                    first = current.next;
                    current.next.prev = null;
                    size--;
                    return true;
                } else if (i == size()-1) {
                    last = current.prev;
                    size--;
                    return true;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (final Object item : this) {
            if (!c.contains(item)) this.remove(item);
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public T remove(final int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);

        Item<T> current = first;
        for (int i = 0; i < size(); i++) {
            if (index == size-1 && index == i) {
                last = current.prev;
                size--;
                return current.getElement();
            } else if (index == 0) {
                first = current.next;
                current.next.prev = null;
                size--;
                return current.getElement();
            } else if (index == i) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return current.getElement();
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public List<T> subList(final int start, final int end) {
        return null;
    }

    @Override
    public ListIterator listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public ListIterator listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public int lastIndexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(final int index, final T element) {
        checkElementIndex(index);

        for (int i = 0; i < size; i++) {
            if (i == index) {
//                Item<T> item = get(index);

            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(final int index, final T element) {
        Item<T> ref = first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                ref.element = element;
                return ref.element;
            }
            ref = ref.next;
        }
        return null;
    }

    @Override
    public T get(final int index) {
        checkElementIndex(index);

        Item<T> ref = first;
        for (int i = 0; i < index; i++) {
            ref = ref.getNext();
        }
        return ref.getElement();
    }

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> current;
        private Item<T> last;

        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {
//            checkElementIndex(index);

            current = first;
            if (index > 0) {
                int i = 0;
                while (i != index) {
                    current = current.getNext();
                    i++;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            last = current;
            current = current.next;
            return last.element;
        }

        @Override
        public void add(final T element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(final T element) {
            if (last == null) throw new IllegalStateException();
            last.element = element;
            last = null;
        }

        @Override
        public int previousIndex(){
            for (int i = 0; i < size(); i++) {
                if (get(i).equals(last.getElement())) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int nextIndex() {
            for (int i = 0; i < size; i++) {
                if (get(i).equals(current.getElement())) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public boolean hasPrevious() {
            return last != null;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            if (last == null) {
                last = current;
            }
            if (current != null) {
                current = current.prev;
            }
            return last.element;
        }

        @Override
        public void remove() {
            if (last == null) throw new IllegalStateException();
            if (last.next == null) {
                last.prev = last.prev.getPrev();
                last = null;
            } else if (last.prev == null) {
                last.next = last.next.getNext();
                last = null;
            } else {
                last.prev = last.prev.getPrev();
                last.next = last.next.getNext();
                last = null;
            }
            size--;
        }
    }

    private static class Item<T> {

        private T element;
        private Item<T> next;
        private Item<T> prev;

        public Item(final T element, final Item<T> prev, final Item<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getElement() {
            return element;
        }

        public Item<T> getNext() {
            return next;
        }

        public Item<T> getPrev() {
            return prev;
        }
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException();
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
}
