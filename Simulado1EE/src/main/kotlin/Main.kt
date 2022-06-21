import kotlin.collections.List

/*  1.)
Implemente a classe Par de valores e a função zip que transforma um par
de listas em uma lista de pares. Utilize estas definições para definir
uma função para somar 2 listas.
somar(1,2,3)(4,5,6) = (5,7,9)
zip(1,2,3)(4,5,6) = (Par(1,4),Par(2,5),Par(3,6))
*/
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

class Par(val v1:Int,val v2:Int) {
    override fun toString():String {
        return "($v1,$v2)"
    }
}

fun zip(l1:List<Int>,l2:List<Int>,index:Int):NoLista<Par>? {
    if(index >= l1.size || index >= l2.size) {
        return null
    }
    else {
        return NoLista(Par(l1[index],l2[index]),zip(l1,l2,index + 1))
    }
}

fun soma(l1:List<Int>,l2:List<Int>,index:Int):NoLista<Int>? {
    val lista = zip(l1,l2,index)
    if(lista == null) {
        return null
    }
    else {
        return NoLista(lista.valor.v1 + lista.valor.v2,soma(l1,l2,index + 1))
    }
}

/*  2.)
Defina uma função para concatenação de duas listas em duas versões:
a) Concatenar mantendo a posição dos elementos
Concat(1,2,5)(3,5,6) = (1,2,5,3,5,6)

b) Concatenar duas listas ordenadas mantendo a ordenação
merge(1,2,5)(3,5,6) = (1,2,3,5,5,6)

-utilize as funções acima para implementar os algoritmos de mergesort e quicksort
*/
fun concat(l1:List<Int>,l2:List<Int>,index1:Int,index2:Int):NoLista<Int>? {
    if(index1<l1.size){
        return NoLista(l1[index1],concat(l1,l2,index1+1,index2))
    }
    else if(index2<l2.size){
        return NoLista(l2[index2],concat(l1,l2,index1,index2+1))
    }
    else{
        return null
    }
}
//fun merge(l1:List<Int>,l2:List<Int>):NoLista<Int>{

//}

/*  3.)
Escreva uma função que divida uma lista de Strings em uma lista de linhas formadas
pelas palavras separadas por espaços de forma que nenhuma linha possua mais que 40
caracteres
*/
/*
fun divide(l1:List<String>,index:Int):NoLista<String>?{
if(index<l1.size){
if(l1[index].length>40){
return NoLista(l1[index].substring(0,40)+"\n", divide(listOf(l1[index].substring(40)),index))
}
else{
return NoLista(l1[index]+"\n",null)
}
}
else{
return null
}
}
*/
fun divide(l1:List<String>,index:Int,soma:Int):NoLista<String>?{
    if(index>=l1.size) {
        return null
    }
    else if(soma+(l1[index].trim().length+1)<40){
       // println(l1[index].trim())
       // println(soma+(l1[index].trim().length+1))
        return NoLista(l1[index].trim()+" ",divide(l1,index+1,soma+l1[index].trim().length+1))

    }
    else{
        return NoLista(l1[index].trim()+"\n",divide(l1,index+1,0))
    }
}

//Main
fun main(args:Array<String>) {

//questão 1:
    val a1 = listOf(1,2,3)
    val a2 = listOf(4,5,6)
//    val qzip = zip(a1,a2,0)
//    println(qzip?.print())
//    val qsoma = soma(a1,a2,0)
//    println(qsoma?.print())
    val qConcat = concat(a1,a2,0,0)
//println(qConcat?.print())
    val strings = listOf<String>("bom","dia","pra","quem?",
        "diego","rativa","paraguay","boliviano","columbiano",
        "do","cartel","de","trafico","de","papagaio")
//val qdivide = divide(strings,0)
    val qdivide = divide(strings,0,0)
    println(qdivide?.print())
}
