methodName ="toUpperCase"
str = "hello"
methodOfInterest = String.metaClass.getMetaMethod(methodName)
println methodOfInterest.invoke(str)

print "Does String respond to toUpperCase() ? "
println String.metaClass.respondsTo(str,"toUpperCase") ? "yes" : "no"

print "Does String respond to compareTo(String) ? "
println String.metaClass.respondsTo(str,"compareTo","test") ? "yes" : "no"

print "Does String respond to compareTo(int) ? "
println String.metaClass.respondsTo(str,"toUpperCase",5) ? "yes" : "no"
