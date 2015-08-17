def foo(int a, int... b){
    println "You passed $a and $b"
}

def foo2(int a,int[] b){
    println "You passed $a and $b"
}

foo(1,2,3,4,5,6)
foo2(1,2,3,4,5,6)