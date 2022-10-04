package model

class Jugador(
    id: Int, nombre: String, private var posicion: String, private var valor: Int, private var puntuacion: Int
) : Persona(id, nombre) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Posicion: $posicion")
        println("Valor: $valor")
        println("Puntuacion: $puntuacion\n")

    }

    fun getValor(): Int {
        return valor
    }

    fun getPuntuacion(): Int {
        return puntuacion
    }

    fun getPosicion(): String {
        return posicion
    }

}