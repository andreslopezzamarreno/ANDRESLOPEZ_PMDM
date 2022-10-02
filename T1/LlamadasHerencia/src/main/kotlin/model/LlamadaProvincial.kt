package model

class LlamadaProvincial(numOrigen: Int, numDestino: Int, duracion: Int) : Llamada(numOrigen, numDestino, duracion) {

    //Las llamadas provinciales que cuestan 15 céntimos el segundo.
    init {
        coste = duracion * 15
    }
}