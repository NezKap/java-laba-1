package org.example;

import java.util.Objects;

public class List<T> {
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T _value) {
            value = _value;
            next = null;
        }
    }
    private Node<T> start;
    private Node<T> end;
    private int count;
    public List() {
        start = null;
        end = null;
        count = 0;
    }
}
