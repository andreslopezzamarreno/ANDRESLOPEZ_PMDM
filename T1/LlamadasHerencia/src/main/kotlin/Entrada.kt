import model.Centralita
import model.LlamadaLocal
import model.LlamadaNacional
import model.LlamadaProvincial

fun main() {
    var centralita = Centralita()
    var opcion: Int

    do {
        println(
            "Que quieres hacer\n1.Registrar Llamada\n2.Mostrar costes totales\n3.Mostrar Llamadas realizadas" +
                    "\n4.Salir"
        )
        opcion = readln().toInt()
        when (opcion) {
            1 -> {
                var numero1: Int
                var numero2: Int
                var duration: Int
                //registrar Llamada
                println("Que tipo de llamada es\n1.local\n2.Provincial\n3.Nacional")
                opcion = readln().toInt()
                println("Numero de origen")
                numero1 = readln().toInt()
                println("Numero de destino")
                numero2 = readln().toInt()
                println("Duracion")
                duration = readln().toInt()
                when (opcion) {
                    1 -> {
                        centralita.registrarLlamada(LlamadaLocal(numero1, numero2, duration))
                    }
                    2 -> {
                        centralita.registrarLlamada(LlamadaProvincial(numero1, numero2, duration))
                    }
                    3 -> {
                        var franja: Int
                        println("franja")
                        franja = readln().toInt()
                        centralita.registrarLlamada(LlamadaNacional(numero1, numero2, duration, franja))
                    }
                }
            }
            2 -> {
                //Mostrar costes totales
                centralita.mostrarCostes()
            }
            3 -> {
                //Mostrar Llamadas realizadas
                centralita.mostrarLlamadas()
            }
            4 -> println("SALIR")
        }
    } while (opcion != 4)
}