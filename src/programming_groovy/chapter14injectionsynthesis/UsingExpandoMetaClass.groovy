/**
 * add daysFromNow method to Integer using metaClass (ExpandoMetaClass)
 * it receives a closure
 */
Integer.metaClass.daysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH,delegate)
    today.time
}
/**
 * add daysFromNow property to Integer class using metaClass aka ExpandoMetaClass
 * to define a property called 'someProperty',you should define a method called 'getSomeProperty'
 */
Integer.metaClass.getDaysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH,delegate)
    today.time
}
/**
 * to define this method in Short and Long and so on, you should reuse closure like this
 */
daysFromNow = { ->
    Calendar today = Calendar.instance
    today.add(Calendar.DAY_OF_MONTH,(int)delegate)
    today.time
}
Long.metaClass.daysFromNow = daysFromNow
Short.metaClass.daysFromNow = daysFromNow

//println 5.daysFromNow()
//
//println 3.daysFromNow
//
//println 4l.daysFromNow()

/**
 * Inject static method
 */
Integer.metaClass.static.isEven = { val ->
    val % 2 == 0
}
println Integer.isEven(5)

/**
 * Intercepting existing constructor
 */
Integer.metaClass.constructor = { val ->
    println "Intercepting constructor call"
    constructor = Integer.class.getConstructor(Integer.TYPE)
    constructor.newInstance(val)
}
/**
 * Intercepting a new constructor
 */
Integer.metaClass.constructor << {Calendar calendar ->
    new Integer(calendar.get(Calendar.DAY_OF_YEAR))
}

println new Integer(3)
println new Integer(Calendar.instance)