ExpandoMetaClass.enableGlobally()
Object.metaClass.delegateCallsTo = {Class... clazzOfDelegates ->
    def objectOfDelegates = clazzOfDelegates.collect(){
        it.newInstance()
    }
    delegate.metaClass.methodMissing = {String name,args
        println "Intercepting $name "
        def delegateTo = objectOfDelegates.find{
            it.metaClass.respondsTo(it,name,args)
        }
        if(delegateTo){
            delegateTo.metaClass."${name}" = {Object[] varArgs ->
                def params = varArgs ?: null
                return delegateTo.invokeMethod(name,*params)
            }

            return delegateTo.invokeMethod(name,args)
        }else {
            throw new MissingMethodException(name,delegateTo.class,args)
        }

    }
}

class NewManager {
    {delegateCallsTo Worker, Expert, GregorianCalendar}
    def schedule (){
        println "Scheduling ..."
    }
}

ann = new NewManager()
ann.simpleWork1("hehe")