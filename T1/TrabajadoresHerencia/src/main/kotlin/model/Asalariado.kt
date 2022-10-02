package model

class Asalariado(nombre: String, apellido: String, dni: String, private var salario: Double, private var nPagas: Int) :
    Trabajador(
        nombre, apellido, dni
    ) {

    var contratado: Boolean = false


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario Anual: $salario")
        println("Salario Mensual: ${salario / nPagas}")
        println("Numero de pagas: $nPagas")
    }
}