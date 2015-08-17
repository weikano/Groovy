list = [1,2,3,4,5]
println list.findAll{it>3}
println list.findAll{it>3}.sum()
//carryOver 初始值为0，carryOver的值会进入下一个闭包
println list.inject {carryOver ,item ->
    println "carryOver $carryOver and item $item"
    carryOver +=1
}

list.identity {
    list.add(6)
    list.add(7)

    println list
}

println list.join(" ")

println list.dump()

def numbers(a,b,c,d,e){
    println "$a $b $c $d $e"
}
//*将集合展开
numbers(*list)
