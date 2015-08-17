def printInfo(obj){
    usrRequestedProperty = "bytes"
    usrRequestedMethod = "toUpperCase"

    println obj[usrRequestedProperty]
    println obj."$usrRequestedProperty"

    println obj."$usrRequestedMethod"()
    println obj.invokeMethod(usrRequestedMethod,null)
}

class PropertyTest{

}

test = new PropertyTest()
["hehe","haha"].each {it ->
    test."$it" = "111"
//    println test.getAt(it)
}
println test.dump()



printInfo('hello')