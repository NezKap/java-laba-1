package org.example;

/**
 * Класс для демонстрации методов класса List,
 * показыающий работа всвех методов на списках,
 * составленных из элементов различных типов данных
 * @author Егор
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> firstList = new List<>();
        System.out.println(firstList);
        firstList.addElem(1);
        firstList.addElem(2);
        firstList.addToTheBeginning(5);
        System.out.println("List after adding 1 and 2: " + firstList);
        System.out.println("Index of the element 5: " + firstList.getIndex(5));
        System.out.println("Number of elements in the list: " + firstList.getCount());
        System.out.println("Element 2 is in the list: " + firstList.findElem(2));
        firstList.remove(1);
        System.out.println("List after deleting element with index 1: " + firstList);
        System.out.println("Number of elements in the list after deleting the element: " + firstList.getCount());
        firstList.removeAtTheBeginning();
        System.out.println("List after deleting element at the beginning: " + firstList);
        System.out.println("Index of the element 2 in the list: " + firstList.getIndex(2));
        firstList.clear();
        System.out.println("List after deleting all the elements: " + firstList);
        System.out.println("List is empty: " + firstList.isEmpty());
        List<String> secondList = new List<>();
        System.out.println(secondList);
        secondList.addElem("abc");
        secondList.addElem("cde");
        System.out.println("List after adding elements \"abc\" and \"cde\": " + secondList);
        System.out.println("Index of the element \"cde\" in the list: " + secondList.getIndex("cde"));
        secondList.remove(0);
        System.out.println("List after deleting element with index 0: " + secondList);
        System.out.println("Value of the element with index 0: " + secondList.getValue(0));
        secondList.addElem("efg");
        System.out.println("List after adding element \"efg\": " + secondList);
        System.out.println("Value of the last element in the list: " + secondList.getValueOfLastElem());
    }
}