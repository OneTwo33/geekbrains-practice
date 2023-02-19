package ru.onetwo33.practice.homework5;

public interface IBaseDAO<T> {

    void persist(final T instance);
    void remove(final T instance);
    T merge(final T instance);
    T findById(final Long id, Class<?> persistClass);
}