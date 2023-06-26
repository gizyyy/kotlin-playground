package inheritance

import java.util.*

//all classes in kotlin final if you dont add open keyword
open class TeamLead(val isSenior: Boolean, override val name: String, override val department: Department) : Manager {
    override fun evaluatePerformance(personId: Long): Int {
        if (personId == 0L) throw UserIsNotProvidedException()
        println("Team lead evaluation done by $name for department $department for personal $personId")
        return Random().nextInt()
    }

    fun evaluatePerformanceDueToCompanyMetric(function: (Long) -> Int, personId: Long): Int {
        return function(personId)
    }

}

class GroupLead(val groupName: String, name: String, department: Department) : TeamLead(false, name, department) {
    // i dont have to but i can still override
    override fun evaluatePerformance(personId: Long): Int {
        if (personId == 0L) throw UserIsNotProvidedException()

        println("Group lead evaluation done by $name for personal $personId")
        return Random().nextInt()
    }
}

// way to create custom exception
class UserIsNotProvidedException : RuntimeException()


fun main(args: Array<String>) {
    var lambda = {x:Long -> x.toInt()}

    var lambdaShortCut = {x:Long -> x.toInt()}

    val seniorTeamLead = TeamLead(true, "christian", Department.IT)
   // passing a function as parameter
    seniorTeamLead.evaluatePerformanceDueToCompanyMetric(::someDummyFunction,0L)
    //passing a lambda as parameter
    seniorTeamLead.evaluatePerformanceDueToCompanyMetric(lambda, 0L)
    val groupLead = GroupLead("smallGroup", "luca", Department.PRODUCT)
    seniorTeamLead.evaluatePerformance(123L);



}

fun someDummyFunction(input: Long): Int = 0

