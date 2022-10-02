package model

class Asalariado(nombre: String, apellido: String, dni: String) : Trabajador(
    nombre, apellido, dni
) {

    private var salario:Double = 0.0
        get() = field
        set(value) {
            field = value
        }
    private var nPagas:Int = 0
        get() = field
        set(value) {
            field = value
        }
    private var contratado: Boolean = false
        get() = field
        set(value) {
            field = value
        }

    constructor(nombre: String,apellido: String,dni: String,salario:Double, nPagas: Int): this(nombre, apellido, dni){
        this.salario = salario
        this.nPagas= nPagas
    }
    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario Anual: $salario")
        println("Salario Mensual: ${salario/nPagas}")
        println("Numero de pagas: $nPagas")
    }
}