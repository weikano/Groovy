class ComplexNumber {
    def real, imaginary
    def plus(other){
        new ComplexNumber(real: real + other.real, imaginary: imaginary + other.imaginary)
    }

    String toString(){
        "ComplexNumber real $real, imaginary $imaginary"
    }
}

def c1 = new ComplexNumber(real: 100,imaginary: 1)
def c2 = new ComplexNumber(real: 200, imaginary: 2)
println c1+c2

class OddInteger extends BigDecimal {

    OddInteger(double val) {
        super(val)
    }
    /**
     * overloading add method
     * @param augend
     * @return
     */
    @Override
    BigDecimal add(BigDecimal augend) {
        println "overloading add method called"
        intValue() - augend.intValue()
    }


}

def o1 = new OddInteger(100);
def o2 = new OddInteger(50);
println o1+o2
println o1.plus(100)