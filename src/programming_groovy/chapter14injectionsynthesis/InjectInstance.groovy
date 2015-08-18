class Person {}
def emc = new ExpandoMetaClass(Person)
emc.sing = { ->
    println "hahaha"
}
//emc.initialize()

jack = new Person()
jack.metaClass = emc
jack.sing()

roman = new Person()
try{
    roman.sing()

}catch(ex){
    println ex
}

