package polynomial;

public class PolynomialTerm<T extends Comparable<T>> {
    T coefficient;
    T exponent;
    PolynomialTerm<T> next;

    // Constructor
    public PolynomialTerm(T coefficient, T exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }

    @Override
    public String toString() {
        if ((Integer) exponent == 0) {
            return coefficient.toString();
        }
        if ((Integer) exponent == 1) {
            return coefficient + "x";
        }
        return coefficient + "x^" + exponent;
    }
}
