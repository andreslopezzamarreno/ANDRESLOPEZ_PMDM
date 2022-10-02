package model

class Jefe(nombre: String, apellido: String, dni: String,var acciones: Int,var beneficio: Double) : Trabajador(
    nombre, apellido, dni
) {
    /*
    private var acciones: Int = 0
    private var beneficio:Double = 0.0

    constructor(nombre: String,apellido: String,dni: String,acciones: Int, beneficio:Double): this(nombre, apellido, dni)

    */
    fun despedirTrabajador(){

    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Acciones: $acciones")
        println("Beneficio: $beneficio")
    }
}