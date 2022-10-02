package model

abstract class Llamada(var numOrigen: Int, var numDestino: Int, var duracion: Int) {

    var coste: Int = 0

    open fun mostrarDatos() {
        println()
        println("Numero Origen: $numOrigen")
        println("Numero Destino: $numDestino")
        println("Duracion : $duracion")
        println("Coste : $coste \n")
    }
}