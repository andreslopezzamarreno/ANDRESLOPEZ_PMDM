package model

import kotlin.math.max

class Fantasy {
    /*
    Una clase Fantasy, la cual representa el juego. La clase tiene los siguientes
    atributos: conjunto de jugadores, conjunto de jugadores que se pueden fichar.
     */
    private var participantes: ArrayList<Participante>

    private var jugadores: ArrayList<Jugador>

    private var ganador: Participante? = null

    init {
        participantes = ArrayList()
        jugadores = ArrayList()

        jugadores.add(Jugador(1, "Marc-André ter Stegen", "Portero", 3000000, 10))
        jugadores.add(Jugador(2, "Ronald Araújo", "Defensa", 4000000, 0))
        jugadores.add(Jugador(3, "Eric García", "Defensa", 1000000, 3))
        jugadores.add(Jugador(4, "Pedri", "Mediocentro", 5000000, 23))
        jugadores.add(Jugador(5, "Robert Lewandowski", "Delantero", 8000000, 15))
        jugadores.add(Jugador(6, "Courtois", "Portero", 3000000, 1))
        jugadores.add(Jugador(7, "David Alaba", "Defensa", 4000000, 5))
        jugadores.add(Jugador(8, "Jesús Vallejo", "Defensa", 500000, 10))
        jugadores.add(Jugador(9, "Luka Modric", "Mediocentro", 5000000, 5))
        jugadores.add(Jugador(10, "Karim Benzema", "Delantero", 8000000, 10))
        jugadores.add(Jugador(11, "Ledesma", "Portero", 500000, 6))
        jugadores.add(Jugador(12, "Juan Cala", "Defensa", 300000, 3))
        jugadores.add(Jugador(13, "Zaldua", "Defensa", 400000, 6))
        jugadores.add(Jugador(14, "Alez Fernández", "Mediocentro", 700000, 9))
        jugadores.add(Jugador(15, "Choco Lozano", "Delantero", 800000, 4))
        jugadores.add(Jugador(16, "Rajković", "Portero", 300000, 3))
        jugadores.add(Jugador(17, "Raíllo", "Defensa", 200000, 6))
        jugadores.add(Jugador(18, "Maffeo", "Defensa", 300000, 0))
        jugadores.add(Jugador(19, "Ruiz de Galarreta", "Mediocentro", 400000, 7))
        jugadores.add(Jugador(20, "Remiro", "Portero", 1000000, 3))
        jugadores.add(Jugador(21, "Elustondo", "Defensa", 900000, 5))
        jugadores.add(Jugador(22, "Zubeldia", "Defensa", 800000, 6))
        jugadores.add(Jugador(23, "Zubimendi", "Mediocentro", 1000000, 7))
        jugadores.add(Jugador(24, "Take Kubo", "Delantero", 800000, 4))
        jugadores.add(Jugador(25, "Ángel", "Delantero", 300000, 4))
    }

    fun iniciarJuego(administrador: Administrador) {

    }

    fun listarJugadores() {
        println("Mostrar jugadores con valor > 3000000")
        jugadores.forEach { if (it.getValor() >= 3000000) it.mostrarDatos() }
    }

    fun mostrarGanador() {
        var max = -1
        for (participante in participantes) {
            if (participante.getplantilla()?.size == 6) {
                if (participante.getPuntos() > max) setGanador(participante)
            }
        }
        println("\n\n\n\nEL GANADOR ES:")
        ganador?.mostrarDatos()
    }

    fun comprobarParticipante(participante: Participante) {
    }

    fun getJugadores(): ArrayList<Jugador> {
        return jugadores
    }

    fun getParticipantes(): ArrayList<Participante> {
        return participantes
    }

    fun getGanador(): Participante? {
        return ganador
    }

    fun setGanador(participante: Participante) {
        ganador = participante
    }
}