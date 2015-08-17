def takeHelper(helper){
    if(helper.metaClass.respondsTo(helper,"helpMoveThings")){
        helper.helpMoveThings()
    }
    if(helper.metaClass.respondsTo(helper,"eatSugarcane")){
        helper.eatSugarcane();
    }
}

class Man {
    def void helpMoveThings(){
        println "I'm a man"
    }
}

class Women {
    def void helpMoveThings(){
        println "I'm a women"
    }
}

class Elephant{
    def void helpMoveThings(){
        println "I'm an elephant"
    }

    def void eatSugarcane(){
        println "I need some sugarcane"
    }
}

class Dead {
    //do nothing
}

takeHelper(new Man())
takeHelper(new Women())
takeHelper(new Elephant())
takeHelper(new Dead())