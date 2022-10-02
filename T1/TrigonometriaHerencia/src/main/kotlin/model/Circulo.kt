package model

class Circulo(private var radio: Double) : Figura() {

    override fun calcularArea(): Double {
        var area: Double
        area = Math.PI * (Math.pow(radio, 2.0))
        println("El area es $area")
        return area
    }

    fun calcularDiametro(): Double {
        var diametro: Double
        diametro = radio * 2
        return diametro
    }
}