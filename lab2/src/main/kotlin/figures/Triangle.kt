package figures

import kotlin.math.sqrt

class Triangle(
    private val a: Double,
    private val b: Double,
    private val c: Double,
    colorHex: String,
): BaseFigure(colorHex = colorHex) {
    override fun getSquare(): Double {
        val halfOfPerimeter = getPerimeter() / 2
        return sqrt(halfOfPerimeter * (halfOfPerimeter - a) * (halfOfPerimeter - b) * (halfOfPerimeter - c))
    }

    override fun getPerimeter() = a + b + c
}