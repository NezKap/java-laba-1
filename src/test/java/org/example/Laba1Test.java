package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для проведения unit-тестов для
 * проверки корректной работы методов
 * класса List
 * @author Егор
 * @version 1.0
 */

public class Laba1Test {

    /**
     * Тестирование работы конструктора списка
     */

    @Test
    void createList() {
        List<Integer> _list = new List<>();
        assertEquals(0, _list.getCount());
        assertTrue(_list.isEmpty());
    }

    /**
     * Тестирование методов добавления элементов в список
     */

    @Test
    void addingElement() {
        List<Integer> _list = new List<>();
        _list.addElem(1);
        _list.addToTheBeginning(2);
        assertEquals(2, _list.getValue(0));
        assertEquals(1, _list.getValue(1));
        assertEquals(2, _list.getCount());
    }

    /**
     * Тестирование методов удаления элементов из списка
     */

    @Test
    void removingElement() {
        List<Integer> _list = new List<>();
        _list.addElem(1);
        _list.addElem(2);
        _list.addElem(3);
        _list.remove(2);
        _list.removeAtTheBeginning();
        assertFalse(_list.findElem(3));
        assertFalse(_list.findElem(1));
    }

    /**
     * Тестирования метода очищения списка
     */

    @Test
    void clearingList() {
        List<Integer> _list = new List<>();
        _list.addElem(1);
        _list.addElem(2);
        _list.clear();
        assertTrue(_list.isEmpty());
    }

    /**
     * Тестирование методов получения значений элементов списка
     */

    @Test
    void gettingValue () {
        List<Integer> _list = new List<>();
        _list.addElem(1);
        _list.addElem(2);
        assertEquals(1, _list.getValue(0));
        assertEquals(2, _list.getValueOfLastElem());
    }

    /**
     * Тестирование метода получения количества элементов списка
     */

    @Test
    void gettingCount() {
        List<Integer> _list = new List<>();
        _list.addElem(1);
        assertEquals(1, _list.getCount());
        _list.addElem(2);
        assertEquals(2, _list.getCount());
    }

    /**
     * ТЕстирования метода поиска элемента по индексу в списке
     */

    @Test
    void findingElement() {
        List<Integer> _list = new List<>();
        _list.addElem(1);
        _list.addElem(2);
        assertTrue(_list.findElem(1));
        assertTrue(_list.findElem(2));
    }

    /**
     * Тестирование метода получения индекса элемента в списке
     */

    @Test
    void gettingIndex() {
        List<Integer> _list = new List<>();
        _list.addElem(1);
        _list.addElem(2);
        assertEquals(1, _list.getIndex(2));
        assertEquals(0, _list.getIndex(1));
    }

    /**
     * Тестирование метода представления элементов
     * списка в виде строки
     */

    @Test
    void printingList() {
        List<Integer> _list = new List<>();
        assertEquals("Empty list", _list.toString());
        _list.addElem(1);
        assertEquals("1", _list.toString());
        _list.addElem(2);
        assertEquals("1 2", _list.toString());
    }

    /**
     * Тестирование обработки исключений при введении
     * неверного индекса
     */

    @Test
    void invalidIndexException() {
        List<Integer> _list = new List<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {_list.remove(0);});
        assertThrows(IndexOutOfBoundsException.class, () -> {_list.getValue(0);});
    }

    /**
     * Тестирование обработки исключений при
     * попытке получить значение последнего элемента
     * в пустом списке
     */

    @Test
    void getLastValueFromEmptyListException() {
        List<Integer> _list = new List<>();
        assertThrows(IllegalStateException.class, () -> {_list.getValueOfLastElem();});
    }
}