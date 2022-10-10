package model

abstract class Persona(protected var id: Int, protected var nombre: String) {

    open fun mostrarDatos() {
        println("id: $id")
        println("nombre: $nombre")
    }
}