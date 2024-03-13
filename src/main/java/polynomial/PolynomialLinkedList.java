package polynomial;

import simpleList.LinkedList;

public class PolynomialLinkedList<T extends Comparable<T>> extends LinkedList<T> {
    PolynomialTerm<T> head;

    public PolynomialLinkedList() {
        this.head = null;
    }

    //Methods of problem 11. Adding a polinomiun of grade n as a simple linked list, where each node has the coefficient and the exponent of the term.

    //Method to add a term to the polinomium at the end of the list.
    public void addPolinomiumTerm(T coefficient, T exponent) {
        PolynomialTerm<T> newTerm = new PolynomialTerm<>(coefficient, exponent);

        if (head == null) {
            head = newTerm;
        } else {
            PolynomialTerm<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTerm;
        }
    }

    //Method to sort the polinomium in descending order of the exponents.
    public void sortPolynomial() {
        if (head == null || head.next == null) {
            return; // The list is already sorted or empty
        }

        PolynomialTerm<T> current = head;
        while (current != null) {
            PolynomialTerm<T> next = current.next;
            while (next != null) {
                if ((Integer) current.exponent < (Integer) next.exponent) {
                    // Swap coefficients
                    T tempCoefficient = current.coefficient;
                    current.coefficient = next.coefficient;
                    next.coefficient = tempCoefficient;

                    // Swap exponents
                    T tempExponent = current.exponent;
                    current.exponent = next.exponent;
                    next.exponent = tempExponent;
                }
                next = next.next;
            }
            current = current.next;
        }
    }

    //Method to print the value table of the polinomium for x values from 0 to 5 with a step of 0.5.
    public void printValueTable() {
        System.out.println("x\t\ty");
        for (double x = 0; x <= 5; x += 0.5) {
            double y = 0;
            PolynomialTerm<T> current = head;
            while (current != null) {
                y += (Integer) current.coefficient * Math.pow(x, (Integer) current.exponent);
                current = current.next;
            }
            System.out.println(x + "\t\t" + y);
        }
    }

    //Method to print the polinomium sorted in descending order of the exponents.
    public void printPolynomial() {
        sortPolynomial();
        PolynomialTerm<T> current = head;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println();
    }
}
