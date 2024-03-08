package funcoes

inline fun transacao(funcao: () -> Unit){
    println("Abrindo transaçâo...")

    try {
        funcao()
    } finally {
        println("Fechando transaçâo")
    }
}

fun main(args: Array<String>) {
    transacao {
        println("Executando SQL 1...")
        println("Executando SQL 2...")
        println("Executando SQL 3...")
    }
}