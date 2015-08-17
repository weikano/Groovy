//Override enum activity method using ExpandoMetaClass
enum WeekendActivity {
    SATURDAY,
    SUNDAY

    String activity(){
        "RELAX"
    }
}

def emc = new ExpandoMetaClass(WeekendActivity)
emc.activity = {"Play"}
WeekendActivity.SUNDAY.metaClass = emc

for(day in WeekendActivity){
    println day.activity()
}