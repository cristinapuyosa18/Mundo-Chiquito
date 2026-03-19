package proyecto2
import java.util.*
import java.io.File

fun grafoMundoChiquito(mazo: MutableList<CartaMostro>): Grafo<CartaMostro>{
    val grafo: Grafo<CartaMostro> = ListasAdyacenciaGrafo<CartaMostro>()
    for(carta in mazo){
        grafo.agregarVertice(carta)
    }
    for(i in 0 until mazo.size){
        for(j in i+1 until mazo.size){
            val carta1 = mazo[i]
            val carta2 = mazo[j]
            if(carta1.getNombre() == carta2.getNombre()){
                throw IllegalArgumentException("No se pueden agregar cartas con el mismo nombre al grafo")
            }
            if (
            (carta1.getNivel() == carta2.getNivel() && carta1.getPoder() != carta2.getPoder() && carta1.getAtributo() != carta2.getAtributo()) || 
            (carta1.getNivel() != carta2.getNivel() && carta1.getPoder() == carta2.getPoder() && carta1.getAtributo() != carta2.getAtributo()) || 
            (carta1.getNivel() != carta2.getNivel() && carta1.getPoder() != carta2.getPoder() && carta1.getAtributo() == carta2.getAtributo())) {
                grafo.conectar(carta1, carta2)
            }
        }
    }
    return grafo
}

fun mundoChiquito(mazo: Grafo<CartaMostro>): MutableSet<Triple<CartaMostro, CartaMostro, CartaMostro>>{
    val resultado = mutableSetOf<Triple<CartaMostro, CartaMostro, CartaMostro>>() 
    for (carta1 in mazo.obtenerVertices()){
        for (carta2 in mazo.obtenerArcosSalida(carta1)){
            for (carta3 in mazo.obtenerArcosSalida(carta2)){
                if (carta1 != carta3 && carta1 != carta2 && carta2 != carta3){
                    resultado.add(Triple(carta1, carta2, carta3))
                }
            }
        }
    }
    return resultado
}


fun imprimir(triple: Triple<CartaMostro, CartaMostro, CartaMostro>){
    println("(${triple.first.getNombre()} ${triple.second.getNombre()} ${triple.third.getNombre()})")
}

fun main(args: Array<String>){
    var lineas = File(args[0]).readLines().drop(1)
    val mazo = mutableListOf<CartaMostro>()


            lineas.forEach { line ->
                val carta = line.split(",")
                val nombre = carta[0]
                val nivel = carta[1].toInt()
                val atributo = carta[2]
                val poder = carta[3].toInt()
                val cartaMostro = CartaMostro(nombre, nivel, poder, atributo)
                mazo.add(cartaMostro)

    val grafo = grafoMundoChiquito(mazo)
    val resultado = mundoChiquito(grafo)
    for (triple in resultado){
        imprimir(triple)
    }
}
