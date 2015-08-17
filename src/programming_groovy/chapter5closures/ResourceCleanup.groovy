class Resource {
    def open(){
        println "open"
    }
    def close(){
        println "close"
    }
    def read(){
        println "read"
    }
    def write(){
        println "write"
    }

    def use(clos){
        open()
        clos this
        close()
    }
}

def res = new Resource();
res.use(){
    it.read()
    it.write()
}