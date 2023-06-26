package basics

data class Human(val name: String, val age: Int, var address: String) {

    constructor(name: String, age: Int, address: String, mobileNumber: String) : this(name, age, address) {
        this.mobileNumber = mobileNumber
    }

    var favoriteColor: String? = null
    var mobileNumber: String? = null
    var isAdult: Boolean = false
    var contactPreferred: Boolean = false
        get() = mobileNumber != null

    init {
        isAdult = isAdult(age)
    }

    //usage of elvis operator, checking null, converting a nullable to non nullable
    fun getSafeMobileNumber(): String = mobileNumber ?: ""

    companion object {
        //static variable
        var adultDefaultAge = 18

        // //static method
        fun isAdult(age: Int): Boolean = age >= adultDefaultAge

        //switch statement
        fun getAgeKeyword(age: Int): String {
            return when {
                age > 70 -> "Senior"
                age > 18 -> "Adult"
                else -> "Kid"
            }
        }

        //null safety
        fun formatMobileNumber(number: String?): String? = number?.removePrefix("+49")

        fun capitalizeFavoriteColor(color: String): String = color.uppercase()
    }

}

fun main() {

    //deconstructing example
    //feature of data class
    val (name, age, address) = Human("Gizem", 35, "Germany")
    println("$name $age $address")

    // we have a toString because of data class
    val human = Human("Gizem", 35, "Germany")
    human.mobileNumber = "+49someNumber"
    println("we have a new human: $human")

    //init works after first constructor
    if (human.isAdult)
        println("${human.name} is an adult")

    //static method call
    if (human.contactPreferred)
        println("You can reach this human from ${Human.formatMobileNumber(human.mobileNumber)}")

    //feature of data class
    println(human.hashCode())
    println(human.equals(null))
    //static method call
    println(Human.isAdult(human.age))

    //using second constructor
    val human2 = Human("Gizem", 35, "Germany", "someNumber")
    println(human == human2)

    //below code does not compile, we may use let
    //Human.capitalizeFavoriteColor(human.favoriteColor)

    //if favoriteColor is not null return capitalized else ""
    human.favoriteColor?.let { x -> Human.capitalizeFavoriteColor(x) } ?: ""

    // collectioins and iterations
    for (i in 0..9) {
        println("Hello $i")
    }

    val humans = ArrayList<Human>()
    humans.add(human)
    humans.add(human2)
    (0 until humans.size).forEach { println(humans[it].age) }

    humans.forEach { human -> println(human) }

    for (human in humans) {
        println("Hello $human")
    }

    //Map
    val humansMap = HashMap<Int, Human>()
    humansMap[1] = human
    humansMap[2] = human2

    for ((key, value) in humansMap)
        println("$key - $value")

   // immutables mapOf<>() setOf<>() listOf<>()
   //  mutables HashMap ArrayList Set mutableListOf<>() mutableMapOf<>() mutableSetOf<>()
}

