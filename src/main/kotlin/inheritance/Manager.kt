package inheritance

interface Manager {

    val name: String
    val department : Department

    fun evaluatePerformance(personId:Long) : Int

}


enum class Department{
    IT,
    PRODUCT
}