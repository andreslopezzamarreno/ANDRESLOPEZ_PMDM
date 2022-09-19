//VARIABLES - FUNCIONES - CLASES

//Funciones: fun nombre(arg: Tipo){
//return
// }

//Funciones: fun nombre(arg: Tipo): Tipo_retorno{
//}

//funcion main
fun main(arg: Array<String>) {

    //dos tipos de variables var o val
    //val es constante (final)
    //var es normal (corriente como en java)
    //lateinit

    //Tipo nombre: tipo = valor

    var nombre:String? = null
    var edad: Int = 21
    val DNI = "1345345E"


/*
    //operador elvis: en el caso de que una variable sea nula pone un valor por defecto en el momento de la ejecucion
    println(nombre?.length ?: "el valor es nulo")

    //"Scanner" de Java
    nombre = readLine()

    println("Primera ejecucion de kotlin")

    //dar formato al un print
    println("Hola soy ${nombre} y tengo ${edad}")

    //Tambien se pueden hacer operaciones
    println("la suma de los numeros 2 y 4 es ${2+4}")

*/


    //estructuraIf()
    //estructuraFor()
    //ejercicioAleatorios()
    //funcionArrays()
    //ejercicioPalabrasPares()
    funcionlistas()
}

// fun nombre (parametros): Tipo_retorno --> Unit es el void de java
fun estructuraIf(){
    println("Estructura de control if")

    //no existe el if ternario
    //inicializacion de varible
    var nombre: String? = null

    println("Introduce tu nombre")
    nombre = readLine()

    //Evaluar si la longitud del nombre es mas grande que 5
    //en ese caso sacar por consola "nombre demasiado grande" sino "nombre correcto"

    //puede que en readline siga siendo nulo por lo que ponemos que sea 7
    if (nombre?.length ?: 7 > 5){
        println("nombre nulo o demasiado grande")
    }else{
        println("nombre correcto")
    }
}

fun funcionlistas(){
    //list --> Listas mutables --> ArrayList

    var listaAlumnosKt = ArrayList<String>()

    listaAlumnosKt.add("Alumno1")
    listaAlumnosKt.add("Alumno1_")
    listaAlumnosKt.add("Alumno2")
    listaAlumnosKt.add("Alumno2_")
    listaAlumnosKt.add("Alumno3")
    listaAlumnosKt.add("Alumno4")
    listaAlumnosKt.add("Alumno5")
    listaAlumnosKt.add("Alumno5_")


    /*
    println( listaAlumnosKt.get(0))

    //con solo un parametro
    listaAlumnosKt.forEach({ println(it) })

    //cuando solo un parametro pero quiero cambiar el nombre al "it"
    listaAlumnosKt.forEach({ value -> println(value) })

    //listaAlumnosKt.set(0,"alumnoNuevo")
    listaAlumnosKt.forEach({nombre -> println(nombre) })

    //listaAlumnosKt.remove("Alumno1")
    //listaAlumnosKt.removeAt(0)

    listaAlumnosKt.removeIf({elemento -> elemento.contains("_")})
    listaAlumnosKt.forEach({println(it)})

    //nota: no funciona el .find
    listaAlumnosKt.find ({it.contains("_1")})
     */



}

fun estructuraFor(){
    // for (int i=0;i<11;i++){}
    // for (i in 1..10){}
    /*for (i in 1..50 step 5){
        println(i)
        // (int) (Math.random() * 51)
        //var aleatorio = (1..50).random()
        //println(aleatorio)
    }*/
    // 1..10 10..1

    /*for (i in 10 downTo 0){
        println(i)
    }
     */

    for (i in 10 until 20){
        println(i)
    }

}

fun ejercicioAleatorios(){
    /*generar 10 aleatorioes entre 1-100
    calculando la suma de todos
    la media de todos
    el numero max
    el numero min
    */
    var edad = 0
    println("Que edad tienes")
    edad = readLine()!!.toInt()
    if(edad < 18){
        println("klk")
    }else{
        var suma= 0
        var max=0
        var min=101

        for (i in 0..9){
            var aleatorio = (1..100).random()
            if (aleatorio > max){
                max = aleatorio
            }
            if (aleatorio < min){
                min = aleatorio
            }
            suma += aleatorio
            println(aleatorio)
        }

        println("Suma: ${suma}")
        println("Media: ${suma/10}")
        println("Max: ${max}")
        println("Min: ${min}")
    }
}

fun funcionArrays(){
    var arrayPalabras: Array<String?> = arrayOfNulls<String>(5)

    arrayPalabras[0] = "hola"
    arrayPalabras[1] = "que"
    arrayPalabras[2] = "tal"
    arrayPalabras[3] = "estas"
    arrayPalabras[4] = "tu"

    println(arrayPalabras[4]?.length)

    for(i in arrayPalabras){
        println(i + " ")
    }

    for (i in 0..arrayPalabras.size-1){
        println(arrayPalabras.get(i))
    }

    arrayPalabras.forEach{ println(it) }
    //tambien se puede escribir de esta forma cambiando el it general por el "item" que quiera
    arrayPalabras.forEach{ palabra -> println(palabra) }

    arrayPalabras.forEachIndexed({index, value -> println("${index} ${value}")})

}

fun ejercicioPalabrasPares(){
    //sacar palabras en posiciones pares
    //sacar palabras que tengan longitud de al menos 5

    var arrayPalabras: Array<String?> = arrayOfNulls<String>(5)

    arrayPalabras.set(0,"hola")
    arrayPalabras[1] = "que"
    arrayPalabras[2] = "tal"
    arrayPalabras[3] = "estas"
    arrayPalabras[4] = "tu"


    //sacar palabras en posiciones pares
    for (i in 0..arrayPalabras.size-1 step 2){
        println(arrayPalabras.get(i) + " ")
    }

    //sacar palabras en posiciones pares
    arrayPalabras.forEachIndexed { index, value ->if (index % 2 ==0) println(value) }

    //sacar palabras que tengan longitud de al menos 5
    arrayPalabras.forEach {
        if(it!!.length>=5){
            println(it)
        }
    }

    print("Filtrado: ")
    //sacar palabras que tengan longitud de al menos 5
    var listaFiltrada = arrayPalabras.filter({value -> value?.length!! >= 5 } )
    listaFiltrada.forEach({ println(it) })
}