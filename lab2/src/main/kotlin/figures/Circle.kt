package figures

import kotlin.math.pow

class Circle(private val radius: Double, colorHex: String): BaseFigure(colorHex = colorHex) {
    override fun getSquare() = Math.PI * radius.pow(2)

    override fun getPerimeter() = 2 * Math.PI * radius
}