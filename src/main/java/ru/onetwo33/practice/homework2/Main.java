package ru.onetwo33.practice.homework2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(500);

        if (list.contains(300))
            System.out.println("Yes");

        list.forEach(System.out::println);
    }
}
