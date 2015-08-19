import com.sun.corba.se.spi.orbutil.threadpool.Work

ExpandoMetaClass.enableGlobally()

class Worker {
    def simpleWork1(spec) {
        println "worker does work1 with spec $spec"
    }

    def simpleWork2() {
        println "worker does work2"
    }
}

class Expert {
    def advanceWork1(spec) {
        println "Expert does work1 with spec $spec"
    }

    def advanceWork2(scope, spec) {
        println "Expert does work2 with scope $scope spec $spec"
    }
}

class Manager {
    def worker = new Worker()
    def expert = new Expert()

    def schedule() {
        println "Scheduling ..."
    }

    def methodMissing(String name, args) {
        println "intercepting call to $name and args $args..."
        def delegateTo = null
        if (name.startsWith("simple")) {
            delegateTo = worker
        } else if (name.startsWith("advance")) {
            delegateTo = expert
        }
        if (delegateTo?.metaClass.respondsTo(delegateTo, name, args)) {
            Manager.metaClass."${name}" = { Object[] varArgs ->
                return delegateTo.invokeMethod(name, *varArgs)
            }
            return delegateTo.invokeMethod(name, args)
        }else{
            throw new MissingMethodException(name, Manager.class, args)
        }

//        if(delegateTo?.metaClass.respondsTo(delegateTo,name,args)){
//            Manager.metaClass."${name}" = {Object[] varArgs ->
//                return delegateTo.invokeMethod(name, *varArgs)
//            }
//
//            return delegateTo.invokeMethod(name,args)
//        }

    }
}

peter = new Manager()
peter.schedule()
peter.simpleWork1("fast")
peter.simpleWork1("quality")
peter.simpleWork2()
peter.simpleWork2()
peter.advanceWork1("fast")
peter.advanceWork1("quality")
peter.advanceWork2("protype", "fast")
peter.advanceWork2("protype", "qualit")

try {
    peter.simpleWork3()
} catch (ex) {
    println ex
}