package programming_groovy.chapter14injectionsynthesis
//class StringUtil {
//    def static toSSN(self){
//        if(self.size() == 9){
//            return "${self[0..2]}-${self[3..4]}-${self[5..8]}"
//        }
//    }
//}
//class FindUtil {
//    def static extractOnly(String self, clos){
//        def result = ""
//        self.each {it ->
//            if(clos.call(it)){
//                result += it
//            }
//        }
//        result
//    }
//}
//use(StringUtil){
//    println "123456789".toSSN()
//    println new StringBuffer("123456789").toSSN()
////    println [1,2,3,4,5,6,7,8,9].toSSN()
//}
//
//use(FindUtil){
//    println "123456789".extractOnly{
//        it=='3'
//    }
//}
//
//use(StringUtil, FindUtil){
//    println "123456789".toSSN()
//    println "123456789".extractOnly{
//        it == '3' || it == '4'
//    }
//}

class TestToString {
    def String toString(){
        "hehe"
    }
}

class Helper {
    def static toString(self){
        def method = self.metaClass.methods.find {it.name == "toString"}
        if(method != null){
            return '!!'+method.invoke(self, null) +'!!'
        }else{
            return "no toString method"
        }
    }
}
//use(programming_groovy.chapter14injectionsynthesis.Helper){
//    println new programming_groovy.chapter14injectionsynthesis.TestToString().toString()
//    println "haha".toString()
//}

println Helper.toString(new TestToString())