package domain

import java.util.UUID

// id and name is immutable
data class Student(val id: UUID, val name: String, var age: Int, var notes: ArrayList<Note>) {
    //a dummy property, example for overriding the setter of a field
    var approved: Boolean = false
        set(value) {
            if (age >= defaultMinAge) {
                field = true
            }
        }

    //a dummy property, example for overriding a getter
    val capitalName: String
        get() = capitalize(name)


    //second constructor
    constructor(name: String, age: Int) : this(UUID.randomUUID(), name, age, ArrayList<Note>())

    // runs everytime when primary constructor runs
    init {
        println("New student $id is created")
        //i can also put logic here if i want to run
        if (age < 0)
            age = defaultMinAge
    }

    fun receiveNote(note: Note) {
        notes.add(note)
    }

    //overriding a class function
    override fun toString(): String = "$id $name $age"

    // static function
    companion object {
        const val defaultMinAge:Int = 7
        fun getExampleInstance(): Student = Student(UUID.randomUUID(), "Gizem", 34, ArrayList())
        fun capitalize(input: String): String = input.uppercase()
    }
}