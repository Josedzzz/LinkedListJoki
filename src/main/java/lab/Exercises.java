package lab;

import doubleList.DoubleLinkedList;
import simpleList.LinkedList;

import java.util.Iterator;

public class Exercises {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.printLinkedList();

        //Results for the exercises
        //1. Gets all the numbers in an odd position
        LinkedList<Integer> ans1 = getOddPositionNumbers(list);
        ans1.printLinkedList();

        //2. Obtain the list of persons who have an Id with an even number
        LinkedList<Person> people = new LinkedList<>();
        Person p1 = new Person("Jose", "Amaya", "123");
        Person p2 = new Person("Juan", "Arce", "1234");
        Person p3 = new Person("Daniel", "Correa", "12");
        people.addLast(p1);
        people.addLast(p2);
        people.addLast(p3);
        people.printLinkedList();

        LinkedList<Person> ans2 = getPersonsWithEvenId(people);
        ans2.printLinkedList();

        //3. Removes all the even numbers in the linkedList
        removeEvenNumbers(list);
        list.printLinkedList();

        //CLEAR THE LIST
        list.clear();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.printLinkedList();

        //4. Gets all the odd numbers
        LinkedList<Integer> ans4 = getOddNumbers(list);
        ans4.printLinkedList();

        //5. Count the repetitions for a certain value
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.addLast(2);
        list.addLast(1);
        list.addLast(2);
        list.printLinkedList();
        int count = countValueReps(list, 2);
        System.out.println("The repetitions for the value: " + count);

        //6. Print the doubleLinkedList backwards
        DoubleLinkedList<Integer> doubleList = new DoubleLinkedList<>();
        doubleList.addLast(1);
        doubleList.addLast(2);
        doubleList.addLast(3);
        doubleList.addLast(4);
        doubleList.addLast(5);
        doubleList.printLinkedList();
        doubleList.printBackwards();

        //8. Obtain the list of persons who have an Id with an even number in a doubleLinkedList
        DoubleLinkedList<Person> doublePeople = new DoubleLinkedList<>();
        doublePeople.addLast(p1);
        doublePeople.addLast(p2);
        doublePeople.addLast(p3);
        DoubleLinkedList<Person> ans8 = getPersonsWithEvenId(doublePeople);
        doublePeople.printLinkedList();
        ans8.printLinkedList();
    }

    /**
     * 1. Gets all the numbers in an odd position
     * @param list
     * @return
     */
    public static LinkedList<Integer> getOddPositionNumbers(LinkedList<Integer> list) {
        LinkedList<Integer> oddNumbers = new LinkedList<>();
        int i = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (i % 2 != 0) {
                oddNumbers.addLast(list.getValue(i));
            }
            iterator.next();
            i++;
        }
        return oddNumbers;
    }

    /**
     * 2. Obtain the list of persons who have an Id with an even number
     * @param list
     * @return
     */
    public static LinkedList<Person> getPersonsWithEvenId(LinkedList<Person> list) {
        LinkedList<Person> personsList = new LinkedList<>();
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            if (p.isIdEven()) {
                personsList.addLast(p);
            }
        }
        return personsList;
    }

    /**
     * 3. Removes all the even numbers in the linkedList
     * @param list
     */
    public static void removeEvenNumbers(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (n % 2 == 0) {
                list.remove(n);
            }
        }
    }

    /**
     * 4. Gets all the odd numbers
     * @return
     */
    public static LinkedList<Integer> getOddNumbers(LinkedList<Integer> list) {
        LinkedList<Integer> oddNumbers = new LinkedList<>();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (n % 2 != 0) {
                oddNumbers.addLast(n);
            }
        }
        return oddNumbers;
    }

    /**
     * 5. Gets the count of repetitions for a certain value
     * @param list
     * @param value
     * @return
     */
    public static int countValueReps(LinkedList<Integer> list, int value) {
        int count = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int aux = iterator.next();
            if (aux == value) {
                count++;
            }
        }
        return count;
    }

    /**
     * 8. Obtain the list of persons who have an Id with an even number in a doubleLinkedList
     * @param list
     * @return
     */
    public static DoubleLinkedList<Person> getPersonsWithEvenId(DoubleLinkedList<Person> list) {
        DoubleLinkedList<Person> people = new DoubleLinkedList<>();
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            if (p.isIdEven()) {
                people.addLast(p);
            }
        }
        return people;
    }

}
