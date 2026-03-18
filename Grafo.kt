package proyecto2

interface Grafo<T> {
    fun obtenerVertices(): List<T>
    fun idDeVertice(v: T): Int?
    fun agregarVertice(v: T): Boolean
    fun eliminarVertice(v: T): Boolean
    fun conectar(desde: T, hasta: T): Boolean
    fun contiene(v: T): Boolean
    fun obtenerArcosSalida(v: T): List<T>
    fun obtenerArcosEntrada(v: T): List<T>
    fun tamano(): Int
    fun subgrafo(vertices: Collection<T>): Grafo<T>
    data class BFSResultado( val predecesores: IntArray, val distancias: IntArray)
    fun BFS(v: T): BFSResultado
}