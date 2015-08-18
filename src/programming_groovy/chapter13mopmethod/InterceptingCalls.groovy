class Car1 implements GroovyInterceptable {
    def check() {
        System.out.println("check called")
    }

    def start() {
//        println "start called"
        System.out.println("start called")
    }

    def drive(){
//       println "drive called"
        System.out.println("drive called")
    }

    @Override
    Object invokeMethod(String name, Object args) {
        if(name != 'check'){
            System.out.println("runnning filter ....")
            Car1.metaClass.getMetaMethod('check').invoke(this,null)
        }
        def validMethod = Car1.metaClass.getMetaMethod(name,args)
        if(validMethod !=null){
            validMethod.invoke(this,args)
        }else{
            Car1.metaClass.invokeMethod(this,name,args)
        }
//        return super.invokeMethod(name, args)
    }
//    @Override
//    Object invokeMethod(String name, Object args) {
//        println name
//        return super.invokeMethod(name, args)
//    }
//    def invokeMethod(String name, args){
//        println "invokeMethod called"
//        if(name != "check"){
//            println "running filter ..."
//            Car.metaClass.getMetaMethod('check').invoke(this, null)
//        }
//
//        def validMethod = Car.metaClass.getMetaMethod(name,args)
//        if(validMethod != null){
//            validMethod.invoke(this, args)
//        }else{
//            return Car.metaClass.invokeMethod(this,name,args)
//        }
//    };
}

car = new Car1()
car.start()
println ""
car.drive()
println ""
car.check()
println ""
car.speed()