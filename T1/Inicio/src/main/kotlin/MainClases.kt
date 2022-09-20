fun main(){
    var coche1 : Coche = Coche("mercedes","c220",100)

    coche1.aumentarVelocidad(100)
    coche1.disminucionVelocidad(20)
    coche1.parar()

    println( coche1.velocidad)
}