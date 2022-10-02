package model
class Empresa() {

    var trabajadores: ArrayList<Trabajador>
    var hayJefe: Boolean

    init {
        trabajadores = ArrayList()

        hayJefe = false
    }

    fun agregarTrabajador(persona: Trabajador) {
        //todo -> no me añade personas al arraylist
        var existePersona  = true
        if (persona is Jefe) hayJefe = true
        trabajadores.forEach {
            if (it.dni == persona.dni){
                existePersona = false
            }
        }
        if (!existePersona) trabajadores.add(persona)
        //todo: Controlar que no haya mas de un trabajador con el mismo dni
    }


    fun listarTrabajadores(filtro: String) {
        trabajadores.forEach {
            when (filtro) {
                "Asalariados", "asalariado", "1" -> {
                    if (it is Asalariado) {
                        it.mostrarDatos()
                    }
                }
                "Autonomos", "autonomos", "2" -> {
                    if (it is Autonomo) {
                        it.mostrarDatos()
                    }
                }
                "Jefe", "jefe", "3" -> {
                    if (it is Jefe) {
                        it.mostrarDatos()
                    }
                }
            }
        }
    }


    fun listarTrabajadorDni(dni: String) {
        trabajadores.forEach {
            if (it.dni == dni) it.mostrarDatos()
            else println("Trabajador no encontrado")
        }
    }

    fun despedirTrabajador(dniJefe: String, dniTrabajador: String)  {
        var existeJefe: Boolean = false

        if (hayJefe) {
            trabajadores.forEach {
                if (it.dni == dniJefe) {
                    existeJefe = true
                }
            }
            if (existeJefe) {
                trabajadores.forEach {
                    if (it.dni == dniTrabajador) {

                    }
                }
            }
        } else {
            println("No existe jefe")
        }
        //todo: terminar metodo
    }
}

