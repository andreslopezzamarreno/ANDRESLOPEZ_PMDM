package model

class Centralita {

    var llamadas: ArrayList<Llamada>

    init {
        llamadas = ArrayList()
    }

    /*
    Registrar llamadas, mostrar llamadas realizadas (número origen, número destino, duración y coste)
    Mostrar Costes totales
    Mostrar llamadas realizadas
     */
    fun registrarLlamada(llamada: Llamada) {
        llamadas.add(llamada)
    }

    fun mostrarCostes() {
        var suma: Int = 0
        llamadas.forEach {
            suma += it.coste
        }
        println("El coste total de todas las llamadas ha sido $suma")
    }

    fun mostrarLlamadas() {
        llamadas.forEach { it.mostrarDatos() }
    }
}