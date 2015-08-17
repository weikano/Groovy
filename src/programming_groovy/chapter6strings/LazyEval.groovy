quote = "Today ${->company} is closed at ${->time}"
maps = [google : 12, apple : 13]
maps.each {key ,value ->
    company = key
    time = value
    println quote
}