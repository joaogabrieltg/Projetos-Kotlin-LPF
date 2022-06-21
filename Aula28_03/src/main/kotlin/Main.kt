class NoInt(val info:Int, val prox:NoInt?)
class NoFloat(val info:Float, val prox:NoFloat?)
class NoDouble(val info:Double, val prox:NoDouble?)
//para evitar a repetição:
class No<T>(val info:T, val prox:No<T>?)//<T> "tipo parametrizado"
fun <A,B> map(n:No<A>?, f:(A)->B):No<B>?{
//COMPLETAR
return null
}

fun somaFuncionalComChaves(l:No<Int>?):Int {
    if(l==null)//corrigir
        return 0
    else
        return l.info+somaFuncionalComChaves(l.prox)
}

fun somaFuncionalSemChaves(l:No<Int>?) : Int =
    if (l==null)
        0
    else
        l.info + somaFuncionalSemChaves(l.prox)

/**
fun somaAltaOrdem(l:No<Int>) : Int =
reduce(l, 0) { x, y -> x + y}
**/

fun soma(x:Int, y:Int) = x + y /*é igual a*/ val soma = {x:Int, y:Int -> x+y}

//fun não são valores, mas pode ser transformada com ::
val f = ::somaFuncionalComChaves;

//OO pode ser utilizada em kotlin
class Valor(val info: Int){
    fun prox() = Valor(info+1)
}
fun Valor.prev() = Valor(info-1)
fun String.nPalavras() = this.split(" ").size//metodos fora da classe não podem ser redefinidos nas subclasses

/*
Tipo Método: extende o conceito de tipo de funções para métodos
(Int)->Int
Pessoa.(Int)->Int
*/

/**
class Contador(var v:Int) {
    fun incr() {v++}
    fun decr() {v--}
}
var c = Contador(2)
var m : Contador.() -> Unit = Contador.incr
m = Contador.decr
c.m())
**/
/*
em kotlin todos os operadores são chamadas a métodos
 a+b == a.plus(b)
 a-b == a.minus(b)
 a(x) == a.invoke(x)
 a[idx] == a.get(idx)
*/

class Complex(val re:Float, val im:Float){
    operator fun plus(c:Complex)=Complex(re+c.re, im+c.im)
}

/*
biblioteca de coleções de kotlin
tem coleções imperativas(mutáveis) e funcionais(imutáveis)
principais: Listas, Conjuntos e Mapeamentos
possuem funções de alta ordem
*/

//Array<C>
val a1:Array<Int> = arrayOf(1,2,3,4)
val a2:Array<Int?> = arrayOfNulls(10)
val a3 = Array(3){x->x*x+2}
//Arrays não podem ter o seu tamanho modificado, mas os elementos podem ser
//Vargs //COMPLETAR

//List<C>
val lFuncional = listOf(1,2,3,4,5)
val lImperativo= mutableListOf(1,2,3,4,5)

/*
LOGICA FUNCIONAL X IMPERATIVA
 F|F PURAMENTE FUNCIONAL
 F|F IMPERATIVA
 F|F IMPERATIVA
 F|F PURAMENTE IMPERATIVA
*/

//SetOf<C>
val sFuncional = setOf(1,2,3)
//setOf(1,2,3) = setOf(3,2,2,1)
val sImperativo = mutableSetOf(1,2,2,3)

//MapOf<K,V>
val mFun = mapOf(1 to 4, 2 to 8)
val mImp = mutableMapOf(1 to 4, 2 to 8)

fun main(args: Array<String>) {
    println(lImperativo)
    lImperativo.add(6)
    println(lImperativo)
    println(sImperativo)
    sImperativo.add(6)
    println(sImperativo)
    println("Hello World!")
}