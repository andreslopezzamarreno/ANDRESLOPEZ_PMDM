import model.Administrador
import model.Fantasy

import model.Participante

fun main() {
    var ligaFantasy: Fantasy = Fantasy()

    // - Crear 4 jugadores con los nombres que se quieran
    var participante1: Participante = Participante(1, "Juan")
    ligaFantasy.getParticipantes()?.add(participante1)
    var participante2: Participante = Participante(2, "Alberto")
    ligaFantasy.getParticipantes()?.add(participante2)
    var participante3: Participante = Participante(3, "Lucas")
    ligaFantasy.getParticipantes()?.add(participante3)
    var participante4: Participante = Participante(4, "Pedro")
    ligaFantasy.getParticipantes()?.add(participante4)

    //- Los 3 primeros equipos realizan fichajes válidos
    //participante 1
    participante1.ficharJugador(ligaFantasy.getJugadores().get(0))
    participante1.ficharJugador(ligaFantasy.getJugadores().get(16))

    participante1.ficharJugador(ligaFantasy.getJugadores().get(17))
    participante1.ficharJugador(ligaFantasy.getJugadores().get(22))
    participante1.ficharJugador(ligaFantasy.getJugadores().get(13))
    participante1.ficharJugador(ligaFantasy.getJugadores().get(14))
    //participante 2
    participante2.ficharJugador(ligaFantasy.getJugadores().get(10))
    participante2.ficharJugador(ligaFantasy.getJugadores().get(12))
    participante2.ficharJugador(ligaFantasy.getJugadores().get(7))
    participante2.ficharJugador(ligaFantasy.getJugadores().get(13))
    participante2.ficharJugador(ligaFantasy.getJugadores().get(18))
    participante2.ficharJugador(ligaFantasy.getJugadores().get(14))
    //participante 3
    participante3.ficharJugador(ligaFantasy.getJugadores().get(10))
    participante3.ficharJugador(ligaFantasy.getJugadores().get(11))
    participante3.ficharJugador(ligaFantasy.getJugadores().get(12))
    participante3.ficharJugador(ligaFantasy.getJugadores().get(22))
    participante3.ficharJugador(ligaFantasy.getJugadores().get(8))
    participante3.ficharJugador(ligaFantasy.getJugadores().get(14))

    //- El último equipo realiza fichajes y se queda con una plantilla de 5 jugadores
    //participante 4
    participante4.ficharJugador(ligaFantasy.getJugadores().get(0))
    participante4.ficharJugador(ligaFantasy.getJugadores().get(16))
    participante4.ficharJugador(ligaFantasy.getJugadores().get(13))
    participante4.ficharJugador(ligaFantasy.getJugadores().get(3))
    participante4.ficharJugador(ligaFantasy.getJugadores().get(23))

    //- Crea un administrador con los datos que se quieran
    var administrador: Administrador = Administrador(1, "Jorge", 1234)

    //- Listar aquellos jugadores disponibles cuyo valor es superior a 3.000.000€
    ligaFantasy.listarJugadores()

    //- Iniciar el juego
    ligaFantasy.iniciarJuego(administrador)

    //- Muestra el ganador con toda su información
    ligaFantasy.mostrarGanador()
}