package model

class Autonomo(nombre: String, apellido: String, dni: String, private var sueldo: Double) : Trabajador(
    nombre, apellido, dni
) {
    var contratado: Boolean = false


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario Anual: ${sueldo * 12}")
    }
}