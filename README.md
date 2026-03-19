# Mundo-Chiquito

El objetivo es desarrollar un algoritmo en Kotlin que ayude a los jugadores a encontrar todas las posibles combinaciones de cartas mostro (puentes) que satisfacen las condiciones de Mundo chiquito.

---

## Integrantes:

- Cristina Puyosa carnet: 23-10395
- Jean Sifontes carnet: 22-10387

---

## Descripción

Se implementó usando un grafo no-dirigido cuyos vértices V es el conjunto de las instancias de CartaMostro y E es el conjunto que contiene los pares de tarjetas que comparten exactamente un atributo.

Utilizamos dicho grafo para la generación de tripletas. El proceso consistió en recorrer la totalidad de las cartas del mazo para identificar sus nodos adyacentes (aquellas cartas que comparten exactamente un atributo). Posteriormente, se localizaron los adyacentes de estos nodos secundarios, permitiendo así identificar todas las combinaciones posibles dentro de la estructura.

## Análisis de las funciones


| Función | Input | Output | Complejidad | Estructura de Datos |
| :--- | :--- | :--- | :--- | :--- |
| **grafoMundoChiquito** | `MutableList<CartaMostro>` | `Grafo<CartaMostro>` | O(V^2) | **Listas de Adyacencia:** Representa el grafo $G=(V, E)$. |
| **mundoChiquito** | `Grafo<CartaMostro>` | `Set<Triple<...>>` | O(V \cdot D^2) (Donde D es el grado mayor del rafo) | **MutableSet / Triple:** Almacena combinaciones únicas (ternas). |
| **imprimir** | `Triple<CartaMostro, ...>` | | O(1) | **String:** Formatea y muestra los nombres de las cartas. |
| **main** | `System.in` |  | O(V) | **MutableList:** Almacena las cartas leídas de `deck.csv`. |
