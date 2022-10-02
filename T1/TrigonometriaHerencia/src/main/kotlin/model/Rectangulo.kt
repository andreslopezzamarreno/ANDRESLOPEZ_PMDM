package model

class Rectangulo(private var base: Double, private var altura: Double) : Figura() {

    override fun calcularArea(): Double {
        var area = base * altura
        println("El area es $area")
        return area
    }

    fun calcularPerimetro(): Double {
        var perimetro: Double
        perimetro = 2 * (base + altura)
        return perimetro
    }
}
