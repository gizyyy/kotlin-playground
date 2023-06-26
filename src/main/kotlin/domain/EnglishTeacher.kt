package domain

import java.util.*

class EnglishTeacher(
    override var studentList: MutableList<Student>,
    override var name: String,
    override var lesson: Lesson
) : Teacher {

    override fun giveNote(student: Student) {
        var wtf = Random().nextInt(10)
        student.receiveNote(Note(Lesson.ENGLISH, wtf, wtf))
    }

    override fun acceptStudent(student: Student) {
        super.acceptStudent(student)
        println("Welcome to my english lessons ${student.name}")
    }


}