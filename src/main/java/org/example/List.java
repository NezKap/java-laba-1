package org.example;

import java.util.Objects;

/**
 * Класс контейнера, реализованный на основе списка,
 * позволяющий хранить произвольное число объектов
 * @param <T> тип данных элементов списка
 * @author Егор
 * @version 1.0
 */

public class List<T> {

    /**
     * Класс звена, содержащий один элемент списка
     * @param <T> тип данных элемента звена
     */

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

    /**
     * Конструктор класса списка,
     * создающий пустой список с нулевым
     * количеством элементов
     */

    public List() {
        start = null;
        end = null;
        count = 0;
    }

    /**
     * Метод добавления элемента в конец списка
     * @param elem элемент, который необходимо добавить в список
     */

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

    /**
     * Метод добавления элемента в начало списка
     * @param elem элемент, который необходимо добавить в список
     */

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

    /**
     * Метод удаления элемента по индексу из списка
     * @param index индекс удаляемого элемента
     * @throws IndexOutOfBoundsException при введении некорректного индекса
     */

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

    /**
     * Метод удаления элемента из начала списка
     */

    public void removeAtTheBeginning() {
        start = start.next;
        if (start == null) {
            end = null;
        }
    }

    /**
     * Метод удаления всех элементов списка
     */

    public void clear() {
        start = null;
        end = null;
        count = 0;
    }

    /**
     * Метод получения значения элемента, расположенного
     * по заданному индексу
     * @param index индекс элемента, значение которого необходимо получить
     * @return элемент по введённому индексу
     * @throws IndexOutOfBoundsException при введении некорректного индекса
     */

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

    /**
     * Метод получения значения последнего элемента списка
     * @return последний элемент списка
     * @throws IllegalStateException при попытке получить значение последнего элемента из пустого списка
     */

    public T getValueOfLastElem() {
        if (end == null) {
            throw new IllegalStateException("List is empty");
        }
        return end.value;
    }

    /**
     * Метод получения количества элементов в списке
     * @return количество элементов в списке
     */

    public int getCount() {
        return count;
    }

    /**
     * Метод, проверяющий, пустой ли список
     * @return true, если список пустой, иначе - false
     */

    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Метод поиска заданного элемента в списке
     * @param elem элемент, который необходимо найти в списке
     * @return true, если введённый элемент найден, иначе - false
     */

    public boolean findElem(T elem) {
        Node<T> _node;
        for (_node = start; _node != null; _node = _node.next) {
            if (Objects.equals(_node.value, elem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод поиска индекса заданного элемента
     * @param elem элемент, индекс которого необходимо найти
     * @return индекс элемента, если он есть в списке, иначе возвращает -1
     */

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

    /**
     * Метод вывода списка в виде строки
     * @return строку, содержащую элементы списка через пробел
     */

    @Override
    public String toString() {
        if (start == null) {
            return "Empty list";
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
