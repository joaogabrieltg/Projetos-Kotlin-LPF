//Sequências
//abordagem Eager
val l1 = listOf(1,2,3,4,5,6,7)
val l2 = l1.map{x->
    println("calculando $x")
    (x*x)+(2*x)
}
val l3 = l1.map{x->x-1}
val l4 = l3.filter{x->x<100 && x>10}//ou val l4 = l3.filter{x-> x in 11..99 }
val l5 = l2.take(4)//pega só os 3 primeiros valores
//não é eficiente, porque desse jeito todos os dados são calculados
//abordagem lazy
val l1L by lazy{listOf(1,2,3,4,5,6,7)}
val l2L by lazy{l1L.map{x->(x*x)+(2*x)}}
val l3L by lazy{l1L.map{x->x-1}}
val l4L by lazy{l3L.filter{x->x<100 && x>10}}
//Sequências (Streams em Java)
/*
 *- Coleção de dados onde os elementos são calculados de maneira lazy
 *- Uso similar ao das listas, porém lazy
 */
val l1S = sequenceOf(1,2,3,4,5,6,7)
val l2S = l1S.map{x->
    println("calculando $x")
    (x*x)+(2*x)
}
val l3S = l1S.map{x->x-1}
val l4S = l3S.filter{x->x<100 && x>10}
val l5S = l2S.take(4)

fun main(args: Array<String>) {
    // sobre var e val
    /**
    p1.a = 2 //erro
    p1 = Par(2,2) //erro
    p2.a = 3 //erro
    **/
    p1.b = 3 //ok
    p2.b = 8 //ok
    p2 = Par(5,6) //ok
    // sobre var e val

    println("Lista")
    l5.forEach {x -> println(x)}
    println("Sequence")
    l5S.forEach {x -> println(x)}
}
// sobre var e val
class Par(val a:Int, var b:Int)
val p1 = Par(1,2)
var p2 = Par(1,2)