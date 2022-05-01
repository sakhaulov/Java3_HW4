package sakhaulov;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sakhaulov.TriangleExceptions.NegativeSideValueException;
import sakhaulov.TriangleExceptions.NotTriangleException;
import sakhaulov.TriangleExceptions.ZeroSideException;

public class TriangleTest {

    @Test
    @DisplayName("Рассчёт площади треугольника с валидными значениями")
    @Tag("Positive")
    @ParameterizedTest
    @CsvSource({ "10, 10, 10, 43.30127",
                 "10, 20, 20, 96.82458",
                 "10, 15, 20, 72.61843"})
    public void getNewTriangleTest(double a, double b, double c, double expectedResult)
            throws NotTriangleException, NegativeSideValueException, ZeroSideException {

        Triangle testTriangle = new Triangle(a, b, c);
        Assertions.assertEquals(testTriangle.getAreaSize(),expectedResult, 1,
                        "Получено неверное значение площади треугольника");
    }


    @Test
    @DisplayName("Создание фигуры, не являющейся треугольником")
    @Tag("Negative")
    @ParameterizedTest
    @CsvSource({ "100, 10, 10",
                 "10, 100, 10",
                 "10, 10, 100"})
    public void wrongSidesTest(double a, double b, double c) {

        Assertions.assertThrows(NotTriangleException.class,
                                () -> new Triangle(a, b, c),
                         "Отсутствует исключение NotTriangleException");
    }


    @Test
    @DisplayName("Создание треугольника с отрицательным значением стороны")
    @Tag("Negative")
    @ParameterizedTest
    @CsvSource({ "-10, 10, 10",
                 "10, -20, 20",
                 "10, 15, -20"})
    public void negativeSideTest(double a, double b, double c) {

        Assertions.assertThrows(NegativeSideValueException.class,
                () -> new Triangle(a, b, c),
                "Отсутствует исключение NegativeSideValueException");
    }


    @Test
    @DisplayName("Создание треугольника с нулевым значением стороны")
    @Tag("Negative")
    @ParameterizedTest
    @CsvSource({ "0, 10, 10",
                 "10, 0, 10",
                 "10, 10, 0"})
    public void zeroSideTest(double a, double b, double c) {

        Assertions.assertThrows(ZeroSideException.class,
                () -> new Triangle(a, b, c),
                "Отсутствует исключение ZeroSideException");
    }

}
