package programming_groovy.chapter11scriptandclass

/**
 * Created by Administrator on 2015/8/17.
 */
class Car {
    int year = 2015
    int miles

    @Override
    String toString() {
        "Car Year $year and miles $miles"
    }
}
