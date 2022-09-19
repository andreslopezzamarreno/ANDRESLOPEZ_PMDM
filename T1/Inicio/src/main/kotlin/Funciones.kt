import com.sun.source.tree.LambdaExpressionTree
import java.lang.invoke.LambdaConversionException
import java.lang.invoke.LambdaMetafactory

fun main(){
    //funcionParametros("hola",5)

    //se puede poner de esta forma para cambiar de orden los argumentos que se pasan
    //funcionParametros(arg1 = "Andres", arg2 = 21)

    //funcionPorDefecto(numeroDos = 7)
    //funcionSuma(5,7)
    //funcionRetorno()

    println(funcionLambdaSuma(1,4))

}

fun funcionSimple(){
    println("Funcion simple ejecutada")
}

fun funcionParametros(arg1: String, arg2: Int){
    println("$arg1")
    println("${arg2 + 3}")
}

fun funcionPorDefecto(numeroUno: Int=200,numeroDos: Int,numeroTres: Int = 100){
    println("${numeroUno+numeroDos+numeroTres}")
}

fun funcionSuma(num1:Int, num2: Int) = println("${num1 + num2}")

fun funcionRetorno(): String{

    return "Andres"
}

var funcionLambdaSuma: (a:Int,b:Int) -> Int = { arg1: Int, arg2: Int ->
    //if con otra forma
    //retorno Int
    if (arg1 > 0 && arg2 > 0) arg1 + arg2 else 0

}