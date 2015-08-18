Integer.metaClass.invokeMethod = { String name, args ->
    System.out.println("Call to $name intercepted on $delegate ...")
    def validMethod = Integer.class.metaClass.getMetaMethod(name,args)
    if(validMethod == null){
        Integer.metaClass.invokeMissingMethod(delegate,name,args)
    }
    System.out.println("running filter ......")
    result = validMethod.invoke(delegate, args)
    System.out.println(result)
    result
}

println 5.floatValue()
println( 5.intValue())
try{
    println 5.empty()
}catch(Exception e) {
    e.printStackTrace()
}
