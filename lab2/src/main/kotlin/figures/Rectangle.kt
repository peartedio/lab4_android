package figures

class Rectangle(
    private val width: Double,
    private val height: Double,
    colorHex: String,
) : BaseFigure(colorHex = colorHex) {
    override fun getSquare() = width * height

    override fun getPerimeter() = 2 * (width + height)
}