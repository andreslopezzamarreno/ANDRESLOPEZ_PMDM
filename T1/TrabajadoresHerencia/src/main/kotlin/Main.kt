import model.*

fun main() {

    val EMPRESA = Empresa()

    var tipo: String
    var opcion: Int

    do {
        println("Que quieres hacer\n1.Registrar Trabajador\n2.listar trabajadores por tipo\n3.Mostrar datos de trabajador\n4.Despedir trabajador")
        opcion = readln().toInt()
        when (opcion) {
            1 -> {
                //egistrar un trabajador. Para ello preguntará si se quiere registrar un asalariado, autónomo o jefe
                // y pedirá los datos del trabajador
                println("Registrar Trabajador (Asalariado/Autónomo/jefe)")
                tipo = readln()
                var nombre: String
                var apellido: String
                var dni: String
                var salario: Double
                var nPagas: Int
                var acciones: Int
                var beneficio: Double

                println("Cual es el nombre?")
                nombre = readln()
                println("Cual es el apellido?")
                apellido = readln()
                println("Cual es el DNI?")
                dni = readln()


                when (tipo) {
                    "Asalariado", "asalariado", "1" -> {
                        println("Cual es el Salario?")
                        salario = readln().toDouble()
                        println("Cuantas pagas tiene?")
                        nPagas = readln().toInt()
                        EMPRESA.agregarTrabajador(Asalariado(nombre, apellido, dni, salario, nPagas))
                    }
                    "Autónomo", "autonomo", "2" -> {
                        println("Cual es el salairo?")
                        salario = readln().toDouble()
                        EMPRESA.agregarTrabajador(Autonomo(nombre, apellido, dni, salario))
                    }
                    "Jefe", "jefe", "3" -> {
                        if (EMPRESA.hayJefe) {
                            println("Ya hay un jefe en la empresa")
                        } else {
                            println("Cuantas acciones tiene?")
                            acciones = readln().toInt()
                            println("Cuanto beneficio tiene?")
                            beneficio = readln().toDouble()
                            EMPRESA.agregarTrabajador(Jefe(nombre, apellido, dni, acciones, beneficio))
                        }
                    }
                }
                println(EMPRESA.trabajadores.size)
            }
            2 -> {
                var tipo: String
                //Listar trabajadores. Para ello preguntará si se quiere listar los asalariados, los autónomos o todos
                println("Listar datos Trabajadores por tipo")
                println("listar Trabajadores (Asalariados/Autónomos/Todos):")
                tipo = readln()
                EMPRESA.listarTrabajadores(tipo)
            }
            3 -> {
                //Mostrar datos de trabajador. Para ello pedirá el DNI
                println("Mostrar datos trabajador por DNI")
                println("listar Trabajador (DNI)")
                var dni: String = readln()
                EMPRESA.listarTrabajadorDni(dni)
            }
            4 -> {
                //Despedir trabajador: Para ello pide el dni del jefe y del trabajador a despedir y elimina a de la lista
                println("Despedir Trabajadores")
                println("dni del jefe")
                var dniJefe: String = readln()
                println("dni del trabajador")
                var dniTrabajador: String = readln()
                EMPRESA.despedirTrabajador(dniJefe, dniTrabajador)
            }
            5 -> println("SALIR")
        }

    } while (opcion != 5)
}