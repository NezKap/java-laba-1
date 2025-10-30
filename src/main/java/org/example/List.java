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
    public void clear() {
        start = null;
        end = null;
        count = 0;
    }
    public T getValue(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException(index);
        }
        Node<T> _node = start;
        for (int i = 0; i < index; i++) {
            _node = _node.next;
        }
        return _node.value;
    }
    public T getValueOfLastElem() {
        if (end == null) {
            throw new IllegalStateException("List is empty");
        }
        return end.value;
    }
    public int getCount() {
        return count;
    }
    public boolean isEmpty() {
        return (count == 0);
    }
    public boolean findElem(T elem) {
        Node<T> _node;
        for (_node = start; _node != null; _node = _node.next) {
            if (Objects.equals(_node.value, elem)) {
                return true;
            }
        }
        return false;
    }
    public int getIndex(T elem) {
        int result = 0;
        Node<T> _node;
        for (_node = start; _node != null; _node = _node.next) {
            if (Objects.equals(_node.value, elem)) {
                return result;
            }
            ++result;
        }
        return -1;
    }
    @Override
    public String toString() {
        if (start == null) {
            return "List is empty";
        }
        String result = "";
        Node<T> _node;
        for (_node = start; _node != null; _node = _node.next) {
            result += _node.value;
            if (_node.next != null) {
                result += " ";
            }
        }
        return result;
    }
}
