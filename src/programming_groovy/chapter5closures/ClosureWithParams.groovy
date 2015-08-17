def tellFortune(clos){
    clos new Date("11/15/2015"), "You are lucky today", "Roman"
}

tellFortune(){date ,fortune,name ->
    println "Date $date ,$name, Fortune $fortune"
}