package inheritance

import java.util.Random

class AgileDeliveryManager : Manager {

    override val name: String
        get() {
           return name
        }

    override val department: Department
        get() =  department

    override fun evaluatePerformance(personId: Long): Int {
        println("ADM evaluation done by $name for department $department for personal $personId")
        return Random().nextInt()
    }
}