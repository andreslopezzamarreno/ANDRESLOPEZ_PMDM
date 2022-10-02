package model

abstract class Trabajador(
    var nombre: String,  var apellido: String, var dni: String){

    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
    }
}