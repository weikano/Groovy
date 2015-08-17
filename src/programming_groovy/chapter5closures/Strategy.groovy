def totalSelectValues(n, closure){
    total = 0
    for(i in 0 .. n){
        if(closure(i)){
            total += i
        }
    }
    total
}

println totalSelectValues(10){it%2==0}
println totalSelectValues(10){it%3!=0}
println totalSelectValues(10) {it>5}
