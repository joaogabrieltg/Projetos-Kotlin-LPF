fun main(args: Array<String>) {
    val l1 = mapOf(1 to 2, 2 to 4, 5 to 2)//chave pra valores
    val l2 = setOf(1,2,3,3,2,1,2,3,2)//conjunto
    val l3 = listOf(1,2,3,4,3)
    //l3.forEach(){x->println(x)}
    //l3.forEach{
    //    println(it)
    //}
    val l4 = l3.map{x -> 2*x}
    println(l4)
    val l5 = l3.filter{x -> x%2==0}
    println(l5)
    println(l3.any{x->x<10})
    println(l3.all{x->x<10})
    val l6 = l3+11
    println(l6)
    println(l6.any{x->x<10})
    println(l6.all{x->x<10})
    println("somatorio = \${l3.fold(0){soma, c-> soma+c}} = ${l3.fold(0){soma, c-> soma+c}}")//fold == reduce
    println("somatorio pode ser \${l3.sum()} = ${l3.sum()}")
    println(l3.fold(0){soma, c-> soma+c}==l3.sum())
    val v1 = 12
    print(l3.reduce({soma, c-> soma+c}))
}