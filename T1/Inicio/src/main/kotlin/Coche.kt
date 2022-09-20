class Coche {

    //VARIABLES
    var marca: String
        get() = field
        set(value) {
            field = value
        }
    var modelo: String
        get() = field
        set(value) {
            field = value
        }
    var cv: Int
        get() = field
        set(value) {
            field = value
        }
    var bastidor: String? = null
    var velocidad: Int? = null

    init {

    }

    //CONSTRUCTORES
    constructor(marca: String, modelo: String, cv: Int) {
        this.marca = marca
        this.modelo = modelo
        this.cv = cv
        this.velocidad = 0
    }

    constructor(marca: String, modelo: String, cv: Int, bastidor: String) {
        this.marca = marca
        this.modelo = modelo
        this.cv = cv
        this.bastidor = bastidor
        this.velocidad = 0
    }

    //METODOS
    //crear metodos que permitan al coche aumentar, reducir y parar (velocidad)
    fun aumentarVelocidad(aumento: Int) {
        this.velocidad = this.velocidad?.plus(aumento)
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