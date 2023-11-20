package figures

import kotlin.math.pow

class Square(private val side: Double, colorHex: String): BaseFigure(colorHex = colorHex) {
    override fun getSquare() = side.pow(2)

    override fun getPerimeter() = 4 * side
}