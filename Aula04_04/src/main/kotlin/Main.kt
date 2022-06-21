/*
  Avaliação lazy
  Somente carregar informações quando o usuário pedir (carregamento tardio de elementos)
*/

//Avaliação Eager(tradicional), quando a variável é declarada, ela é calculada e o programa só é executado após o cálculo
//Lazy só é calculado quando for chamado:
/**
val x by lazy{1+2}
val y by lazy{3*2}
val z by lazy{5-2}
**/
/*
Vantagens:
as variáveis só são calculadas quando necessário
módulos não usados com frequencia não precisam ser carregados
a aplicação pode executar mais rapidamente

Desvantagens:
uma aplicação pode congelar durante a avaliação de uma variável

Exemplos de uso:
páginas web e jogos
 */
//Lazy não é eficiente pra "besteira", usar somente quando necessário
//run c = c()
fun main(args: Array<String>) {
    //Eager
    val xRun = run {
        println("calculando x")
        1+2
    }
    val yRun = run {
        println("calculando y")
        2*3
    }
    val zRun = run {
        println("calculando z")
        5-2
    }
    println("x = $xRun\ny = $yRun\nz = $zRun\n")

    val xLazy by lazy {
        println("calculando x")
        1+2
    }
    val yLazy by lazy {
        println("calculando y")
        2*3
    }
    val zLazy by lazy {
        println("calculando z")
        5-2
    }
    //println("x = $xLazy\ny = $yLazy\nz = $zLazy")
    println(xLazy)
    println(yLazy)
    println(yLazy)
    println(zLazy)
}