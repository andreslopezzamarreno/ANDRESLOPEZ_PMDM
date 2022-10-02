package model

class Triangulo(private var base: Double, private var altura: Double) : Figura() {

    override fun calcularArea(): Double {
        var area = (base * altura) / 2
        println("El area es $area")
        return area
    }
}