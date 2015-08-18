class OtherPerson {
    def work() {
        println "working now ..."
    }

    def plays = ['Tennis','Football','Basketball','Volleyball']

    def methodMissing(String name,args){
        def suffix = name.split("play")[1]
        def methodInList = plays.find{
            suffix == it
        }
        if(methodInList){
            return "playing $suffix"
        }else{
            throw new MissingMethodException(name,Person.class,args)
        }
    }
}

tony = new OtherPerson()
tony.work()
tony.playFootball()
//tony.playPennis()
//tony.playMessage()