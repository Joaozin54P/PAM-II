package funcoes.calculos

import kotlin.math.sqrt

fun main(args: Array<String>) {
    println("Olá seja bem-vindo a CALCULADORA DE ÁREAS:)")
    println("O primeiro passo e escolher qual forma geometrica para calcular a área:")
    println("1. Retângulo")
    println("2. Triângulo")
    println("3. Triângulo Equilátero")
    println("4. Triângulo Isósceles")
    println("5. Triângulo Escaleno")
    println("6. Circunferência")
    println("7. Losango")
    println("8. Trapézio") //println serve para mostrar a linha de texto no console e se preciso "quebrar" a linha tambem
    val choice = readLine()!!.toInt()

    when (choice) { //variavel que apresenta a escolha do usuario, when avalia o valor de choice e executa o código correspondente ao valor que choice possui.
        1 -> calcularAreaDoRetangulo()
        2 -> calcularAreaDoTriangulo()
        3 -> calcularAreaDoTrianguloEquilatero()
        4 -> calcularAreaDoTrianguloIsosceles()
        5 -> calcularAreaDoTrianguloEscaleno()
        6 -> calcularAreaDaCircunferencia()
        7 -> calcularAreaDoLosango()
        8 -> calcularAreaDoTrapezio()
        else -> println("Escolha inválida! Tente novamente mais tarde.")
    }
}

fun calcularAreaDoRetangulo() {
    println("Digite a base do retângulo:")
    val base = readLine()!!.toDouble() //permite que insira valores numericos para calculos
    println("Digite a altura do retângulo:")
    val altura = readLine()!!.toDouble()
    val area = base * altura
    println("A área do retângulo é: $area")
}

fun calcularAreaDoTriangulo() {
    println("Digite a base do triângulo:")
    val base = readLine()!!.toDouble()
    println("Digite a altura do triângulo:")
    val altura = readLine()!!.toDouble()
    val area = 0.5 * base * altura
    println("A área do triângulo é: $area")
}

fun calcularAreaDoTrianguloEquilatero() {
    println("Digite o lado do triângulo equilátero:")
    val lado = readLine()!!.toDouble()
    val area = (sqrt(3.0) / 4) * lado * lado
    println("A área do triângulo equilátero é: $area")
}

fun calcularAreaDoTrianguloIsosceles() {
    println("Digite a base do triângulo isósceles:")
    val base = readLine()!!.toDouble()
    println("Digite o lado do triângulo isósceles:")
    val lado = readLine()!!.toDouble()
    val altura = sqrt(lado * lado - (base * base / 4))
    val area = 0.5 * base * altura
    println("A área do triângulo isósceles é: $area")
}

fun calcularAreaDoTrianguloEscaleno() {
    println("Digite o lado 1 do triângulo escaleno:")
    val lado1 = readLine()!!.toDouble()
    println("Digite o lado 2 do triângulo escaleno:")
    val lado2 = readLine()!!.toDouble()
    println("Digite o lado 3 do triângulo escaleno:")
    val lado3 = readLine()!!.toDouble()
    val s = (lado1 + lado2 + lado3) / 2
    val area = sqrt(s * (s - lado1) * (s - lado2) * (s - lado3))
    println("A área do triângulo escaleno é: $area")
}

fun calcularAreaDaCircunferencia() {
    println("Digite o raio da circunferência:")
    val raio = readLine()!!.toDouble()
    val area = Math.PI * raio * raio
    println("A área da circunferência é: $area")
}

fun calcularAreaDoLosango() {
    println("Digite a diagonal maior do losango:")
    val diagonalMaior = readLine()!!.toDouble()
    println("Digite a diagonal menor do losango:")
    val diagonalMenor = readLine()!!.toDouble()
    val area = (diagonalMaior * diagonalMenor) / 2
    println("A área do losango é: $area")
}

fun calcularAreaDoTrapezio() {
    println("Digite a base maior do trapézio:")
    val baseMaior = readLine()!!.toDouble()
    println("Digite a base menor do trapézio:")
    val baseMenor = readLine()!!.toDouble()
    println("Digite a altura do trapézio:")
    val altura = readLine()!!.toDouble()
    val area = ((baseMaior + baseMenor) * altura) / 2
    println("A área do trapézio é: $area")
}