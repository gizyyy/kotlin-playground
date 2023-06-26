package collectionsexample

import java.math.BigDecimal

//TASK
//creating a stadium, but it should hold an immutable list
data class Stadium(val name: String) {
    private val tempList: MutableList<Seat> = mutableListOf<Seat>()
    private val seats: List<Seat>
        get() {
            return tempList.toList()
        }

    init {
        for (row in 1..20) {
            for (column in 1..20) {
                val seat = Seat(BigDecimal.TEN, row, column, name)
                tempList.add(seat)
            }
        }
    }

    override fun toString(): String {
        for (seat in seats)
            println(seat.toString())
        return super.toString()
    }


}