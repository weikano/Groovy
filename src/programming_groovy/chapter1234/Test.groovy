class Robot {
    def type, height, width

    @Override
    String toString() {
        return "type $type, height $height, width $width"
    }

    def access(Map location,width,fragile){
        println "Received fragile ? $fragile, weight ? $width,loc ? $location"
    }

    def access(location,width, fragile){
        println "Received fragile ? $fragile, weight ? $width,loc ? $location"
    }
}
def robot = new Robot(type: "arm",height: 100,width: 30)
println robot
robot.access(50,x:30,y:20,z:10,true)
robot.access(100,20,40)