class Equipment {
    def calculator
    Equipment(calc){
        calculator = calc
    }
    def simulate(){
        println "do simulate"
        calculator.call()
//        calculator()
    }
}
def knife = new Equipment({
    println "I have a knife"
})
knife.simulate()