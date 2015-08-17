def completeOrder(amount, taxComputer){
    tax = 0;
    //根据闭包的参数个数做区别
    if(taxComputer.maximumNumberOfParameters == 2){
        tax = taxComputer(amount, 6.05)
    }else{
        tax = taxComputer(amount)
    }
    println "tax is $tax"
}

completeOrder(100){
    it * 0.0825
}
completeOrder(100){amount, rate ->
    amount * (rate/100)
}