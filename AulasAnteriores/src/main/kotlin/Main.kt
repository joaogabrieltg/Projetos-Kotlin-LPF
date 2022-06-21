//lambda calculo
//constantes/variávies
//f(a)
//lambda x, f(x)
//O nucleo de uma linguagem lambda-calculo é mais simples do que imperativa
//funções são argumentos
fun combina(f:(Int)->Int,g:(Int)->Int):(Int)->Int={x->f(g(x))}
val f1 = combina({x->(2*x)},{y->(3*y)+1})
//para ED:
class NoLista(val valor:Int, val prox:NoLista?)
//Map
//jeito tradicional: fazer cada função específica
fun incrementar(l:NoLista?):NoLista?{
if(l==null){
    return null
}
    else{
        return NoLista(l.valor+1,incrementar(l.prox))
    }
}
//jeito mais eficiente:
fun map(l:NoLista?,f:(Int)->Int):NoLista?{
    if(l==null){
        return null
    }
    else{
        return NoLista(f(l.valor),map(l.prox,f))
    }
}


fun incrementa(l:NoLista?)=map(l,{x->x+1})
fun decrementa(l:NoLista?)=map(l,{x->x-1}) // ou map(l){x->x-1}

//Filter
//tradicional:
fun par(l:NoLista?):NoLista?{
    if (l==null){
        return null
    }
    else if(l.valor%2==0){
        return NoLista(l.valor,par(l.prox))
    }
    else{
        return par(l.prox)
    }
}
//filter:
fun filter(l:NoLista?,teste:(Int)->Boolean):NoLista? {
    if(l == null) {
        return null
    }
    else if(teste(l.valor)) {
        return NoLista(l.valor,filter(l.prox,teste))
    }
    else {
        return filter(l.prox,teste)
    }
}
fun pares(n:NoLista?):NoLista?=filter(n,{x->x%2==0})
fun impares(n:NoLista?):NoLista?=filter(n,{x->x%2!=0})

//Reduce
fun somatorio(l:NoLista?):Int{
    if(l==null){
        return 0
    }
    else{
        return l.valor+somatorio(l.prox)
    }
}
//reduce
fun reduce(l:NoLista?,v0:Int,op:(Int,Int)->Int):Int{
    if(l==null){
        return v0
    }
    else{
        return reduce(l.prox,op(v0,l.valor),op)
    }
}
fun soma(l:NoLista?) =reduce(l,0,{x,y->x+y})
val tamanho = {l:NoLista?->reduce(l,0,{x,y->x+1})}
fun maior(l:NoLista?)=reduce(l,Int.MIN_VALUE,{x,y->if(x<y)y else x})

//Build
fun pa(v0:Int,r:Int,n:Int):NoLista?{
    if(n<=0){
        return null
    }
    else{
        return NoLista(v0,pa(v0+r,r,n-1))
    }
}
//build
fun build(v0:Int,n:Int,prox:(Int)->Int):NoLista?{
    if(n<=0){
        return null
    }
    else{
        return NoLista(v0,build(prox(v0),n-1,prox))
    }
}
fun PA(v0:Int,n:Int,r:Int)=build(v0,n,{x->x+r})

//GENERICS
class No<T>(val info:T, val prox:No<T>?)
fun <A>map(n:No<A>?, f : (A) -> A):No<A>? {
    if (n==null)
        return null
    else
        return No<A>(f(n.info), map(n.prox, f))
}
fun <A,B>Map(n:No<A>?,f:(A)->B):No<B>? {
    if (n==null)
        return null
    else
        return No<B>(f(n.info), Map(n.prox, f))
}

fun main(args:Array<String>) {
println(f1(10))
    println(soma(NoLista(0,NoLista(1,NoLista(2,NoLista(3,null))))))
}

fun f(vararg array:Int) {
    println("Funcao executada com ${array.size} agumentos")
}
fun main() {
    f(1,2,3)
    f(1)
    f(1,2,3,4)
    f()
}