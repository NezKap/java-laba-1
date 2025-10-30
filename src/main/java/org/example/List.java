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
    public void addElem(T elem) {
        Node<T> _node = new Node<>(elem);
        if (start == null) {
            start = _node;
            end = _node;
        }
        else {
            end.next = _node;
            end = _node;
        }
        ++count;
    }
    public void addToTheBeginning(T elem) {
        Node<T> _node = new Node<>(elem);
        if (start == null) {
            start = _node;
            end = _node;
        }
        else {
            _node.next = start;
            start = _node;
        }
        ++count;
    }
    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0) {
            start = start.next;
            if (start == null) {
                end = null;
            }
        }
        else {
            Node<T> _node = start;
            for (int i = 0; i < index - 1; i++) {
                _node = _node.next;
            }
            if (_node.next == end) {
                end = _node;
            }
            _node.next = _node.next.next;
        }
        --count;
    }
    public void removeAtTheBeginning() {
        start = start.next;
        if (start == null) {
            end = null;
        }
    }
}
