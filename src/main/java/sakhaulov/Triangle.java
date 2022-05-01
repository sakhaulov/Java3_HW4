package sakhaulov;

import sakhaulov.TriangleExceptions.NegativeSideValueException;
import sakhaulov.TriangleExceptions.NotTriangleException;
import sakhaulov.TriangleExceptions.ZeroSideException;

public class Triangle {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c)
            throws NotTriangleException, NegativeSideValueException, ZeroSideException {

        checkSides(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }


    private void checkSides(double a, double b, double c)
            throws NotTriangleException, NegativeSideValueException, ZeroSideException {

        if (a + b < c || a + c < b || b + c < a) {
            throw new NotTriangleException();
        }

        if (a < 0 || b < 0 || c < 0) {
            throw new NegativeSideValueException();
        }

        if (a == 0 || b == 0 || c == 0) {
            throw new ZeroSideException();
        }
    }


    public double getAreaSize() {
        double pp = (a + b + c) / 2.0;
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
    }

}
