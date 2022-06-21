import kotlin.collections.List

//NODE
class NoLista<T>(val valor:T,val prox:NoLista<T>?) {
    fun print():String {
        if(prox == null) {
            return valor.toString()
        }
        else {
            return valor.toString() + "" + prox?.print()
        }
    }
}

//1.)
class Par(val v1:Int,val v2:Int) {
    override fun toString():String {
        return "($v1,$v2)"
    }
}

//NoLista
fun zip(l1:NoLista<Int>?,l2:NoLista<Int>?):NoLista<Par>? {
    if(l1?.prox == null || l2?.prox == null) {
        return NoLista(Par(l1?.valor!!,l2?.valor!!),null)
    }
    else {
        return NoLista(Par(l1?.valor!!,l2?.valor!!),zip(l1.prox,l2.prox))
    }
}

fun soma(l1:NoLista<Int>,l2:NoLista<Int>):NoLista<Int>? {
    val lista = zip(l1,l2)
    if(l1.prox == null || l2.prox == null) {
        return NoLista(lista?.valor?.v1?.plus(lista?.valor?.v2)!!,null)
    }
    else {
        return NoLista(lista?.valor?.v1?.plus(lista?.valor?.v2)!!,soma(l1.prox,l2.prox))
    }
}

//List
fun zipList(l1:List<Int>,l2:List<Int>):List<Par> {
    return List(if(l1.size > l2.size) l1.size else l2.size) { index -> Par(l1[index],l2[index]) }
}

fun somaList(l1:List<Int>,l2:List<Int>):List<Int> {
    val l3 = zipList(l1,l2)
    return List(l3.size) { index -> l3[index].v1 + l3[index].v2 }
}

//2.)A
//NoLista
fun concat(l1:NoLista<Int>?,l2:NoLista<Int>?):NoLista<Int>? {
    if(l1?.prox != null) {
        return NoLista(l1.valor,concat(l1.prox,l2))
    }
    else if(l1?.prox == null && l2?.prox != null) {
        return NoLista(l1?.valor!!,concat(l2,l1))
    }
    else {
        return NoLista(l1?.valor!!,null)
    }
}

//List
fun concatList(l1:List<Int>,l2:List<Int>):List<Int> {
    return List(l1.size + l2.size) { index -> if(index < l1.size) l1[index] else l2[index - l1.size] }
}

//2.)B
//NoLista
fun merge(l1:NoLista<Int>?,l2:NoLista<Int>?):NoLista<Int>? {
    if(l1 == null) {
        return l2
    }
    else if(l2 == null) {
        return l1
    }
    else if(l1.valor < l2.valor) {
        return NoLista(l1.valor,merge(l1.prox,l2))
    }
    else {
        return NoLista(l2.valor,merge(l1,l2.prox))
    }
}

//List
fun mergeList(l1:List<Int>,l2:List<Int>):List<Int> {
    if(l1?.size == 0) {
        return l2
    }
    else if(l2?.size == 0) {
        return l1
    }
    else if(l1[0] < l2[0]) {
        return listOf(l1[0]) + mergeList(l1.drop(1),l2)
    }
    else {
        return listOf(l2[0]) + mergeList(l1,l2.drop(1))
    }
}

//3.)
//NoLista
fun divide(l1:NoLista<String>,soma:Int):NoLista<String>? {
    if(l1.prox == null) {
        return NoLista(l1.valor,null)
    }
    else if(soma + (l1.valor.trim().length + 1) < 40) {
        return NoLista(l1.valor.trim() + " ",divide(l1?.prox!!,soma + l1.valor.trim().length + 1))
    }
    else {
        return NoLista(l1.valor.trim() + "\n",divide(l1?.prox!!,0))
    }
}

//List
fun divideList(l1:List<String>,soma:Int):List<String> {
    if(l1.size == 0) {
        return listOf("")
    }
    else if(soma + (l1[0].trim().length + 1) < 40) {
        return listOf((listOf(l1[0].trim()) + divideList(l1.drop(1),soma + l1[0].trim().length + 1)).toString())
    }
    else {
        return listOf(listOf(l1[0].trim() + "\n",divideList(l1.drop(1),0)).toString())
    }
}

//Main
fun main(args:Array<String>) {
//Questão 1 NoLista
    val a1 = NoLista(1,NoLista(2,NoLista(3,null)))
    val a2 = NoLista(4,NoLista(5,NoLista(6,null)))
    val qzip = zip(a1,a2)
//println(qzip?.print())
    val qsoma = soma(a1,a2)
//println(qsoma?.print())
//Questão 1 List
    val al1 = listOf(1,2,3)
    val al2 = listOf(4,5,6)
    val qzip2 = zipList(al1,al2)
//println(qzip2?.toString())
    val qsoma2 = somaList(al1,al2)
//println(qsoma2?.toString())

//Questão 2A NoLista
    val qConcat = concat(a1,a2)
//println(qConcat?.print())
//Questão 2A List
    val qConcat2 = concatList(al1,al2)
//println(qConcat2?.toString())

//Questão 2B NoLista
    val qMerge = merge(a1,a2)
//println(qMerge?.print())
//Questão 2B List
    val qMerge2 = mergeList(al1,al2)
//println(qMerge2.toString())

//Questão 3 NoLista
    val strings = NoLista(
        "String",NoLista("String",NoLista("String",NoLista("String",NoLista("String",
                NoLista("String",NoLista("String",NoLista("String",NoLista("String",
                    NoLista("String",NoLista("String",NoLista("String",NoLista("String",
                        NoLista("String",NoLista("String",null)))))))))))))))
    val qdivide = divide(strings,0)
    println(qdivide?.print())
//Questão 3 List
    val stringsl = listOf<String>(
        "String","String","String","String",
        "String","String","String","String","String","String","String",
        "String","String","String","String"
    )
    val qdivide2 = divideList(stringsl,0)
    println(qdivide2)
}