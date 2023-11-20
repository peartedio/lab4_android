package calculator

import figures.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.pow
import kotlin.math.sqrt

class CalculatorTest {

    @Test
    fun getSumOfSquare() {
        val circle = Circle(radius = 10.0, colorHex = "#ffffff")
        val rectangle = Rectangle(width = 3.0, height = 5.0, colorHex = "#ffffff")
        val rhombus = Rhombus(diameter1 = 12.0, diameter2 = 16.0, colorHex = "#ffffff")
        val square = Square(side = 4.0, colorHex = "#ffffff")
        val triangle = Triangle(a = 3.0, b = 4.0, c = 5.0, colorHex = "#ffffff")
        assertEquals(Math.PI * 100.0, Calculator.getSumOfSquare(listOf(circle)))
        assertEquals(15.0, Calculator.getSumOfSquare(listOf(rectangle)))
        assertEquals(96.0, Calculator.getSumOfSquare(listOf(rhombus)))
        assertEquals(16.0, Calculator.getSumOfSquare(listOf(square)))
        assertEquals(6.0, Calculator.getSumOfSquare(listOf(triangle)))

        assertEquals(Math.PI * 100.0 + 15.0, Calculator.getSumOfSquare(listOf(circle, rectangle)))
        assertEquals(Math.PI * 100.0 + 96.0, Calculator.getSumOfSquare(listOf(circle, rhombus)))
        assertEquals(Math.PI * 100.0 + 16.0, Calculator.getSumOfSquare(listOf(circle, square)))
        assertEquals(Math.PI * 100.0 + 6.0, Calculator.getSumOfSquare(listOf(circle, triangle)))
        assertEquals(111.0, Calculator.getSumOfSquare(listOf(rectangle, rhombus)))
        assertEquals(31.0, Calculator.getSumOfSquare(listOf(rectangle, square)))
        assertEquals(21.0, Calculator.getSumOfSquare(listOf(rectangle, triangle)))
        assertEquals(112.0, Calculator.getSumOfSquare(listOf(rhombus, square)))
        assertEquals(102.0, Calculator.getSumOfSquare(listOf(rhombus, triangle)))
        assertEquals(22.0, Calculator.getSumOfSquare(listOf(square, triangle)))

        assertEquals(Math.PI * 100.0 + 111.0, Calculator.getSumOfSquare(listOf(circle, rectangle, rhombus)))
        assertEquals(Math.PI * 100.0 + 31.0, Calculator.getSumOfSquare(listOf(circle, rectangle, square)))
        assertEquals(Math.PI * 100.0 + 21.0, Calculator.getSumOfSquare(listOf(circle, rectangle, triangle)))
        assertEquals(Math.PI * 100.0 + 112.0, Calculator.getSumOfSquare(listOf(circle, rhombus, square)))
        assertEquals(Math.PI * 100.0 + 102.0, Calculator.getSumOfSquare(listOf(circle, rhombus, triangle)))
        assertEquals(Math.PI * 100.0 + 22.0, Calculator.getSumOfSquare(listOf(circle, square, triangle)))
        assertEquals(127.0, Calculator.getSumOfSquare(listOf(rectangle, rhombus, square)))
        assertEquals(117.0, Calculator.getSumOfSquare(listOf(rectangle, rhombus, triangle)))
        assertEquals(37.0, Calculator.getSumOfSquare(listOf(rectangle, square, triangle)))
        assertEquals(118.0, Calculator.getSumOfSquare(listOf(rhombus, square, triangle)))

        assertEquals(Math.PI * 100.0 + 127.0, Calculator.getSumOfSquare(listOf(circle, rectangle, rhombus, square)))
        assertEquals(Math.PI * 100.0 + 117.0, Calculator.getSumOfSquare(listOf(circle, rectangle, rhombus, triangle)))
        assertEquals(Math.PI * 100.0 + 37.0, Calculator.getSumOfSquare(listOf(circle, rectangle, square, triangle)))
        assertEquals(Math.PI * 100.0 + 118.0, Calculator.getSumOfSquare(listOf(circle, rhombus, square, triangle)))
        assertEquals(133.0, Calculator.getSumOfSquare(listOf(rectangle, rhombus, square, triangle)))

        assertEquals(Math.PI * 100.0 + 133.0, Calculator.getSumOfSquare(listOf(circle, rectangle, rhombus, square, triangle)))
    }

    @Test
    fun getSumOfPerimeter() {
        val circle = Circle(radius = 10.0, colorHex = "#ffffff")
        val rectangle = Rectangle(width = 3.0, height = 5.0, colorHex = "#ffffff")
        val rhombus = Rhombus(diameter1 = 12.0, diameter2 = 16.0, colorHex = "#ffffff")
        val square = Square(side = 4.0, colorHex = "#ffffff")
        val triangle = Triangle(a = 3.0, b = 4.0, c = 5.0, colorHex = "#ffffff")
        assertEquals(Math.PI * 20.0, Calculator.getSumOfPerimeter(listOf(circle)))
        assertEquals(16.0, Calculator.getSumOfPerimeter(listOf(rectangle)))
        assertEquals(40.0, Calculator.getSumOfPerimeter(listOf(rhombus)))
        assertEquals(16.0, Calculator.getSumOfPerimeter(listOf(square)))
        assertEquals(12.0, Calculator.getSumOfPerimeter(listOf(triangle)))

        assertEquals(Math.PI * 20.0 + 16.0, Calculator.getSumOfPerimeter(listOf(circle, rectangle)))
        assertEquals(Math.PI * 20.0 + 40.0, Calculator.getSumOfPerimeter(listOf(circle, rhombus)))
        assertEquals(Math.PI * 20.0 + 16.0, Calculator.getSumOfPerimeter(listOf(circle, square)))
        assertEquals(Math.PI * 20.0 + 12.0, Calculator.getSumOfPerimeter(listOf(circle, triangle)))
        assertEquals(56.0, Calculator.getSumOfPerimeter(listOf(rectangle, rhombus)))
        assertEquals(32.0, Calculator.getSumOfPerimeter(listOf(rectangle, square)))
        assertEquals(28.0, Calculator.getSumOfPerimeter(listOf(rectangle, triangle)))
        assertEquals(56.0, Calculator.getSumOfPerimeter(listOf(rhombus, square)))
        assertEquals(52.0, Calculator.getSumOfPerimeter(listOf(rhombus, triangle)))
        assertEquals(28.0, Calculator.getSumOfPerimeter(listOf(square, triangle)))

        assertEquals(Math.PI * 20.0 + 56.0, Calculator.getSumOfPerimeter(listOf(circle, rectangle, rhombus)))
        assertEquals(Math.PI * 20.0 + 32.0, Calculator.getSumOfPerimeter(listOf(circle, rectangle, square)))
        assertEquals(Math.PI * 20.0 + 28.0, Calculator.getSumOfPerimeter(listOf(circle, rectangle, triangle)))
        assertEquals(Math.PI * 20.0 + 56.0, Calculator.getSumOfPerimeter(listOf(circle, rhombus, square)))
        assertEquals(Math.PI * 20.0 + 52.0, Calculator.getSumOfPerimeter(listOf(circle, rhombus, triangle)))
        assertEquals(Math.PI * 20.0 + 28.0, Calculator.getSumOfPerimeter(listOf(circle, square, triangle)))
        assertEquals(72.0, Calculator.getSumOfPerimeter(listOf(rectangle, rhombus, square)))
        assertEquals(68.0, Calculator.getSumOfPerimeter(listOf(rectangle, rhombus, triangle)))
        assertEquals(44.0, Calculator.getSumOfPerimeter(listOf(rectangle, square, triangle)))
        assertEquals(68.0, Calculator.getSumOfPerimeter(listOf(rhombus, square, triangle)))

        assertEquals(Math.PI * 20.0 + 72.0, Calculator.getSumOfPerimeter(listOf(circle, rectangle, rhombus, square)))
        assertEquals(Math.PI * 20.0 + 68.0, Calculator.getSumOfPerimeter(listOf(circle, rectangle, rhombus, triangle)))
        assertEquals(Math.PI * 20.0 + 44.0, Calculator.getSumOfPerimeter(listOf(circle, rectangle, square, triangle)))
        assertEquals(Math.PI * 20.0 + 68.0, Calculator.getSumOfPerimeter(listOf(circle, rhombus, square, triangle)))
        assertEquals(84.0, Calculator.getSumOfPerimeter(listOf(rectangle, rhombus, square, triangle)))

        assertEquals(Math.PI * 20.0 + 84.0, Calculator.getSumOfPerimeter(listOf(circle, rectangle, rhombus, square, triangle)))
    }
}