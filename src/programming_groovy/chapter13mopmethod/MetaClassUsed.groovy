class MyClass {}
println 2.metaClass.class.name
println Integer.metaClass.class.name
println 2.metaClass.class.name

obj1 = new MyClass()
println obj1.metaClass.class.name
println MyClass.metaClass.class.name
println obj1.metaClass.class.name

obj2 = new MyClass()
println obj2.metaClass.class.name