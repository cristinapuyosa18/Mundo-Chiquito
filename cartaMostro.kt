package proyecto2

class CartaMostro(private var nombre: String, private var nivel: Int, private var poder: Int, private var atributo: String) {
    init {
        // Nota: la verificación de unicidad de nombre requiere contexto externo (lista/registro de cartas),
        // por lo que debe realizarse fuera de esta clase.
        if (nivel !in 1..12) throw IllegalArgumentException("Nivel debe estar entre 1 y 12")
        if (poder % 50 != 0) throw IllegalArgumentException("Poder debe ser múltiplo de 50")
        val atributosValidos = listOf("AGUA", "FUEGO", "VIENTO", "TIERRA", "LUZ", "OSCURIDAD", "DIVINO")
        if (atributo !in atributosValidos) throw IllegalArgumentException("Atributo debe ser uno de: Fuego, Agua, Viento, Tierra, Luz, Oscuridad")
    }

    fun getNombre() = nombre
    fun getNivel() = nivel
    fun getPoder() = poder
    fun getAtributo() = atributo
     
}               