class No(val valor:Int,val prox:No?) {
    override fun toString():String {
        if(prox != null) {
            return "$valor, $prox"
        }
        else {
            return "$valor"
        }
    }
    fun size():Int{
        if(prox!=null){
            return 1+prox.size()
        }
        else{
            return 1
        }
    }
}

fun fibo(n:Int,v0:Int = 0,v1:Int = 1,vi:Boolean = true):No? {
    if(vi) {
        return No(v0,No(v1,fibo(n-2,v0,v1,false)))
    }
    if(n > 0) {
        return No(v1+v0,fibo(n-1,v1,v1+v0,false))
    }
    else {
        return null
    }
}


fun efibo(n:No,fib:No?=fibo(n.size())):Boolean {
    if(n.prox!=null){
    if(fib?.valor==n.valor){
        return efibo(n.prox,fib.prox)
    }
        else{
            return false
    }
    }
    else{
        return fib?.valor==n.valor
    }
}


fun main() {
    println(efibo(No(0,No(1,No(1,No(2,No(3,null)))))))
}