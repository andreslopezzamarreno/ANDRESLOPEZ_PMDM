import java.util.PropertyResourceBundle

class Coche(var marca: String, var modelo: String) {
    //VARIABLES
    var cv: Int? = null
        set(value) {
            field = value
        }
        get() = field
    var bastidor: String? = null
    var velocidad: Int? = null
    lateinit var propietario: Propietario

    init {

    }

    //CONSTRUCTORES
    constructor(marca: String, modelo: String, cv: Int) : this(marca, modelo) {
        this.cv = cv
        this.velocidad = 0
    }

    constructor(marca: String, modelo: String, cv: Int, bastidor: String) : this(marca, modelo) {
        this.cv = cv
        this.bastidor = bastidor
        this.velocidad = 0
    }

    //METODOS
    //crear metodos que permitan al coche aumentar, reducir y parar (velocidad)
    fun aumentarVelocidad(aumento: Int) {
        this.velocidad = this.velocidad?.plus(aumento)
    }

    fun asignarPropietario() {

    }

    // si intento frenar mas de la v a la que va el coche --> false v =0
    // si intento frenar menos o igual de la v a la que va el coche --> true v = resta
    var disminucionVelocidad: (Int) -> Boolean = { v ->
        if (this.velocidad!! - v < 0) false
        else velocidad = velocidad!! - v; true
    }

    fun parar() {
        for (i in 0..velocidad!! step 10) {
            println(velocidad)
            velocidad = velocidad!! - 10
            Thread.sleep(400)
        }
    }


    fun calcularPar(funcionCalculo : (Int) -> Int, aceleracion: Int){
        //no puedo poner funcionalidad porque no sé como se hace
         funcionCalculo(aceleracion)

    }



    //GETTER SETTER
    // tal cual los sabemos
    fun getVelocidad(): Int {
        return this.velocidad ?: 0;
    }

    fun setVelocidad(velocidad: Int) {
        this.velocidad = velocidad;
    }
    //TOSTRING

}