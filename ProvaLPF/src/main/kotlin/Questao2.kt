class Run(val valor:Int,val vzs:Int) {
    override fun toString():String {
        return "[$valor,$vzs]"
    }
}

fun RunLength(l1:List<Int>,contador:Int = 0):List<Run> {
    fun count(l1:List<Int>,contador:Int = 1,vzs:Int = 1,v0:Int = l1[contador-1]):List<Run> {
        if(contador < l1.size) {
            if(l1[contador] == v0) {
                return listOf(Run(l1[contador],vzs+1))+count(l1,contador+1,vzs+1)
            }
            else {
                return listOf(Run(l1[contador],1))+count(l1,contador+1,1)
            }
        }
        else {
            return emptyList()
        }
    }

    val rl = count(l1)
    if(contador < l1.size-2) {
        if(rl[contador].vzs > rl[contador+1].vzs) {
            return listOf(rl[contador])+RunLength(l1,contador+1)
        }
        else {
            return RunLength(l1,contador+1)
        }
    }
    else {
        return listOf(rl[rl.size-1])
    }
}

fun main() {
    println(RunLength(listOf(1,1,1,2,3,3,3,3,3,0,0,0,0,0,0,0,0,0)))
}