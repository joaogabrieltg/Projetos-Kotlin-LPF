class No<T>(val valor:T,val prox:No<T>?){
    fun print():String{
        if(prox!=null) {
            return valor.toString() + ", " + prox.print()
        }
        else{
            return valor.toString()
        }
    }
}
//questão 1, fatores primos
fun fatores(n:Int,v:Int=2):No<Int>?{
    if(n%v==0){
        return No(v,fatores(n/v,v))
    }
    else if(v+1<=n){
        return fatores(n,v+1)
    }
    else{
        return null
    }
}

//questão 2 a
fun uniao(a:No<Int>?,b:No<Int>?):No<Int>?{
    fun pertence(valor:Int,l:No<Int>):Boolean{
        if(valor == l.valor) {
            return true
        }
        else {
            if(l.prox != null) {
                return pertence(valor,l.prox)
            }
            else {
                return l.prox?.valor == valor
            }
        }
    }
    if(a == null) {
        return b
    }
    else if(b == null) {
        return a
    }
    else {
        if(pertence(a.valor,b)) {
            return uniao(a.prox,b)
        }
        else {
            return No(a.valor,uniao(a.prox,b))
        }
    }
}

//questão 3
fun divide(a:List<Int>,index:Int=0):List<Int>?{
    fun soma(l:List<Int>,ind:Int=0):Int{
        if(ind<l.size) {
            return l[ind] + soma(l,ind + 1)
        }
        else{
            return 0
        }
    }
    if(soma(a.drop(index))>=soma(a.take(index))) {
        println(a.drop(index))
        println(a.take(index))
        return a.drop(index)+a.take(index)
    }
    else{
        return divide(a,index+1)
    }
}

fun main() {
    val fat = fatores(144)
    println("questão 1:\nfatores de 144\n"+fat?.print())
    val a = No(1,No(2,No(3,null)))
    val b = No(3,No(4,No(5,null)))
    println("questão 2 letra A:\nlista a: "+a.print())
    println("lista b: "+b.print())
    println(uniao(a,b)?.print())
    val al= listOf(1,2,3,4,5)
    println("q3: ${divide(al)}")
}