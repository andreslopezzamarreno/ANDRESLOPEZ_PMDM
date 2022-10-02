package model

class LlamadaNacional(numOrigen: Int, numDestino: Int, duracion: Int, var franja: Int) :
    Llamada(numOrigen, numDestino, duracion) {
    //Las llamadas nacionales que dependiendo de la franja horaria en la que se realicen cuestan:
// 20 céntimos en franja 1, 25 céntimos en franja 2 y 30 céntimos en franja 3, cada segundo.
    init {
        when (franja) {
            1 -> coste = duracion * 20
            2 -> coste = duracion * 25
            3 -> coste = duracion * 30
        }
    }

    override fun mostrarDatos() {
        println("Franja: $franja")
        super.mostrarDatos()
    }
}