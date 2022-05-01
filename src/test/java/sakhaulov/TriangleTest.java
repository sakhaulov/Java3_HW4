package sakhaulov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sakhaulov.TriangleExceptions.NegativeSideValueException;
import sakhaulov.TriangleExceptions.NotTriangleException;
import sakhaulov.TriangleExceptions.ZeroSideException;

public class TriangleTest {

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @ParameterizedTest
    @DisplayName("Рассчёт площади треугольника с валидными значениями сторон")
    @Tag("Positive")
    @CsvSource({ "10, 10, 10, 43.30127",
                 "10, 20, 20, 96.82458",
                 "10, 15, 20, 72.61843"})
    public void getNewTriangleTest(double a, double b, double c, double expectedResult)
            throws NotTriangleException, NegativeSideValueException, ZeroSideException {

        Triangle testTriangle = new Triangle(a, b, c);
        Assertions.assertEquals(testTriangle.getAreaSize(),expectedResult, 1,
                        "Получено неверное значение площади треугольника");

        logger.info("Тест getNewTriangleTest пройден");
    }


    @ParameterizedTest
    @DisplayName("Создание фигуры, не являющейся треугольником")
    @Tag("Negative")
    @CsvSource({ "100, 10, 10",
                 "10, 100, 10",
                 "10, 10, 100"})
    public void wrongSidesTest(double a, double b, double c) {

        Assertions.assertThrows(NotTriangleException.class,
                                () -> new Triangle(a, b, c),
                         "Отсутствует исключение NotTriangleException");

        logger.info("Тест wrongSidesTest пройден");
    }


    @ParameterizedTest
    @DisplayName("Создание треугольника с отрицательным значением стороны")
    @Tag("Negative")
    @CsvSource({ "-10, 10, 10",
                 "10, -20, 20",
                 "10, 15, -20"})
    public void negativeSideTest(double a, double b, double c) {

        Assertions.assertThrows(NegativeSideValueException.class,
                () -> new Triangle(a, b, c),
                "Отсутствует исключение NegativeSideValueException");

        logger.info("Тест negativeSideTest пройден");
    }


    @ParameterizedTest
    @DisplayName("Создание треугольника с нулевым значением стороны")
    @Tag("Negative")
    @CsvSource({ "0, 10, 10",
                 "10, 0, 10",
                 "10, 10, 0"})
    public void zeroSideTest(double a, double b, double c) {

        Assertions.assertThrows(ZeroSideException.class,
                () -> new Triangle(a, b, c),
                "Отсутствует исключение ZeroSideException");

        logger.info("Тест zeroSideTest пройден");
    }

}
