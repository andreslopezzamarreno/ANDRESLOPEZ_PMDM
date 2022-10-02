package model
class Empresa() {

    var trabajadores: ArrayList<Trabajador>
    var hayJefe: Boolean

    init {
        trabajadores = ArrayList()
        hayJefe = false
    }

    fun agregarTrabajador(persona: Trabajador) {
        var existePersona  = false
        if (persona is Jefe) hayJefe = true
        trabajadores.forEach {
            if (it.dni == persona.dni){
                existePersona = true
            }
        }
        if (!existePersona) trabajadores.add(persona)
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
                "Todos", "todos", "3" -> {
                    it.mostrarDatos()
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
        var existeJefe = false
        var existePersona = false
        var trabajador:Trabajador? = null

        //comprobar que hay jefe
        if (hayJefe) {
            //para controlar que aunque exista un jefe, concida el dni
            trabajadores.forEach {
                if (it.dni == dniJefe) {
                    existeJefe = true
                }
            }
            //para controlar que existe la persona y encontrarla
            if (existeJefe) {
                trabajadores.forEach {
                    if (it.dni == dniTrabajador) {
                        existePersona= true
                        trabajador = it
                    }
                }
                //despedir a la persona
                if (existePersona) {
                    trabajadores.remove(trabajador)
                    println("Trabajador Despedido")
                }
            }
        } else {
            println("No existe jefe")
        }
    }
}

