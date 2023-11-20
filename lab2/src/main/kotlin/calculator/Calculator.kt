package calculator

import figures.BaseFigure

object Calculator {
    fun getSumOfSquare(figures: List<BaseFigure>): Double = figures.sumOf { it.getSquare() }
    fun getSumOfPerimeter(figures: List<BaseFigure>): Double = figures.sumOf { it.getPerimeter() }
}