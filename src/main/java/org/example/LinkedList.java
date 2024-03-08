package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedList<T> implements Iterable<T> {
    Node<T> head;

    // Constructor
    public LinkedList() {
        this.head = null;
    }

    public Node<T> getHead() {
        return head;
    }

    /**
     *
     * @param value
     */
    public void addAtEnd(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            addAtEnd(head, value);
        }
    }

    /**
     *
     * @param current
     * @param value
     */
    private void addAtEnd(Node<T> current, T value) {
        if (current.next == null) {
            current.next = new Node<>(value);
        } else {
            addAtEnd(current.next, value);
        }
    }

    // Método para agregar un elemento al inicio de la lista
    public void addAtStart(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
    }

    // Método para agregar un elemento en una posición específica
    public void add(T value, int index) {
        if (index < 0) {
            System.out.println("Posición inválida");
            return;
        }
        if (index == 0) {
            addAtStart(value);
            return;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Posición fuera de rango");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Método para obtener el valor de un nodo en una posición específica
    public T getNodeValue(int index) {
        Node<T> current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Posición fuera de rango");
            return null; // Valor por defecto para indicar error
        }
        return current.value;
    }

    // Método para obtener el nodo en una posición específica
    public Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        return current;
    }

    // Método para obtener la posición de un nodo dado su valor
    public int getNodeIndex(T value) {
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Valor por defecto para indicar que no se encontró el valor
    }

    // Método para verificar si la lista está vacía
    public boolean isEmpty() {
        return head == null;
    }

    // Método para eliminar el primer nodo de la lista
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    // Método para eliminar el último nodo de la lista
    public void removeLast() {
        if (head == null || head.next == null) {
            head = null;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    // Método para eliminar un nodo dado su value
    public void remove(T value) {
        if (head == null) {
            return;
        }
        if (head.value.equals(value)) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.value.equals(value)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Método para modificar el valor de un nodo en una posición específica
    public void setNode(int index, T newNode) {
        Node<T> node = getNode(index);
        if (node != null) {
            node.value = newNode;
        } else {
            System.out.println("Posición fuera de rango");
        }
    }

    // Método para ordenar la lista
    public void sortLinkedList() {
        // Implementación del algoritmo de ordenamiento deseado (p. ej., burbuja, selección, etc.)
        // No implementado en esta versión
        System.out.println("Método de ordenamiento no implementado");
    }

    // Método para imprimir la lista
    public void printLinkedList(Node<Integer> head) {
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Método para borrar toda la lista
    public void removeLinkedList() {
        head = null;
    }

    // Método para verificar si un índice es válido
    private boolean isValidIndex(int index) {
        return index >= 0 && index < size();
    }

    // Método para obtener el tamaño de la lista
    private int size() {
        int size = 0;
        Node<T> current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    //Ejercicios exraaaaaa

    public void invert() {
        head = invert(head);
    }

    private Node<T> invert(Node<T> current) {
        if (current == null || current.next == null) {
            return current;
        }
        Node<T> invertedList = invert(current.next);
        current.next.next = current;
        current.next = null;
        return invertedList;
    }

    // Implementación del método iterator de la interfaz Iterable
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> actual = head;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T value = actual.value;
                actual = actual.next;
                return value;
            }
        };
    }
}
