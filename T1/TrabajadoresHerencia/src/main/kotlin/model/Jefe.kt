package model

class Jefe(nombre: String, apellido: String, dni: String, var acciones: Int, var beneficio: Double) : Trabajador(
    nombre, apellido, dni
) {
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Acciones: $acciones")
        println("Beneficio: $beneficio")
    }
}