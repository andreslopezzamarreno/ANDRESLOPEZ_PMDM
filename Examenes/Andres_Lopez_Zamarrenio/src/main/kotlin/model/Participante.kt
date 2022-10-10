package model

class Participante(id: Int, nombre: String) : Persona(id, nombre) {

    private var plantilla: ArrayList<Jugador>? = null

    private var puntos: Int = 0

    private var presupuesto: Int = 10000000


    init {
        plantilla = ArrayList()
    }

    fun ficharJugador(jugador: Jugador) {
        if (comprobar(jugador)) {
            plantilla?.add(jugador)
            puntos += jugador.getPuntuacion()
            presupuesto -= jugador.getValor()
        } else println("jugador no valido para añadir")
    }

    fun comprobar(jugador: Jugador): Boolean {

        if (plantilla?.filter { jugador.getPosicion() == "Portero" }?.size == 0) return true
        if (plantilla?.filter { jugador.getPosicion() == "Defensa" }?.size!! < 1) return true
        if (plantilla?.filter { jugador.getPosicion() == "Mediocentro" }?.size!! < 1) return true
        return plantilla?.filter { jugador.getPosicion() == "Delantero" }?.size == 0
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Puntos: $puntos")
        println("Plantilla:\n")
        plantilla?.forEach { it.mostrarDatos() }
    }

    fun getPresupuesto(): Int {
        return presupuesto
    }

    fun getPuntos(): Int {
        return puntos
    }

    fun getplantilla(): ArrayList<Jugador>? {
        return plantilla
    }
}