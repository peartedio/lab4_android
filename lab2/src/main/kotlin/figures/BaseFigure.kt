package figures

abstract class BaseFigure(val colorHex: String) {
    abstract fun getSquare(): Double
    abstract fun getPerimeter(): Double
}
