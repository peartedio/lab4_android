package figures

import kotlin.math.sqrt
import kotlin.math.pow

class Rhombus(
    private val diameter1: Double,
    private val diameter2: Double,
    colorHex: String,
) : BaseFigure(colorHex = colorHex) {
    override fun getSquare() = diameter1 * diameter2 / 2

    override fun getPerimeter() = 2 * sqrt(diameter1.pow(2) + diameter2.pow(2))
}