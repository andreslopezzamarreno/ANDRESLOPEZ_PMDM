package model

class Autonomo(nombre: String, apellido: String, dni: String) : Trabajador(
    nombre, apellido, dni
) {
    private var sueldo:Double = 0.0
    private var contratado: Boolean = false

    constructor(nombre: String,apellido: String,dni: String,sueldo:Double): this(nombre, apellido, dni){
        this.sueldo = sueldo
    }
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario Anual: ${sueldo *12}")
    }
}