data = new File("car.dat").readLines()
props = data[0].split(", ")
data -= data[0]


def averageMilesDrivenPerYear = {miles.toLong()/(2008 - year.toLong())}
cars = data.collect {lt->
    car = new Expando()
    lt.split(", ").eachWithIndex { Object entry, int i ->
        println "${props[i]} = $entry"
        car[props[i]] = entry
    }
    car.ampy = averageMilesDrivenPerYear
    car
}

props.each {name -> println name}
//println "Avg. MPY "
ampyMethod = "ampy"
cars.each {car ->
    for(String property : props) {
        println "${car[property]}"
//        println car."$ampyMethod"()
    }
}

car = cars[0]
//car.dump()
println "${car.miles} ${car.year} ${car.make} ${car.ampy()}"