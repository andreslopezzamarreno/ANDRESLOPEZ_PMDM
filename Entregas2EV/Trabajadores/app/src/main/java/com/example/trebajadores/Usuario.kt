package com.example.trebajadores

data class Usuario(
    var nombre: String,
    var apellido: String,
    var correo: String,
    var edad: Int,
    var puesto: String
) : java.io.Serializable {
}