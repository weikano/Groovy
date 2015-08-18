/**
 * Using Expando to create object
 * than you can inject year and miles and other properties
 */
carA = new Expando()
carB = new Expando(year : 2007, miles : 0)
carA.year = 2007
carA.miles = 10

println "CAR A $carA"
println "Car B $carB"

/**
 * inject method with key:closure
 */
car = new Expando(year:2007,miles : 0, turn : {
    println "turning ...."
} )
/**
 * dynamic inject method using this format
 */
car.drive = { ->
    println "driving ..."
}

car.turn()
car.drive()

