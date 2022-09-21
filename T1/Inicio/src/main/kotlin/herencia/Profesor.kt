package herencia

class Profesor(nombre: String, apellido: String, dni: String, edad: Int) : Persona(nombre, apellido, dni, edad) {

    var sueldo: Int = 1000

    constructor(nombre: String, apellido: String, dni: String, edad: Int, sueldo: Int) : this(
        nombre,
        apellido,
        dni,
        edad
    ) {
        this.sueldo = sueldo
    }


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Sueldo: $sueldo")
    }
}


