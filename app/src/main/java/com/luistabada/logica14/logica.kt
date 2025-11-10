package com.luistabada.logica14

data class resultadoDivision(
    val cociente: Int,
    val residuo: Int
)
fun divisionResta(dividendo: Int, divisor: Int): resultadoDivision {
    var cociente = 0
    var residuo = dividendo

    while (residuo >= divisor) {
        residuo -= divisor
        cociente++
    }
    return resultadoDivision(cociente, residuo)
}