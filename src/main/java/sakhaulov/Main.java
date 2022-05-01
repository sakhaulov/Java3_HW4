package sakhaulov;

import sakhaulov.TriangleExceptions.NegativeSideValueException;
import sakhaulov.TriangleExceptions.NotTriangleException;
import sakhaulov.TriangleExceptions.ZeroSideException;

public class Main {
    public static void main(String[] args)
            throws NotTriangleException, NegativeSideValueException, ZeroSideException {

        Triangle triangle = new Triangle(1, 1, 1);
        System.out.println(triangle.getAreaSize());

    }
}
