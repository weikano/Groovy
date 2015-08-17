class A {
    boolean equals(other){
        println "equals called"
        return false;
    }
}

class B implements Comparable{
    @Override
    int compareTo(Object o) {
        println "compareTo called"
        return 0
    }
}

new A() == new A()
new B().is(new B())
//new B() == new B()



