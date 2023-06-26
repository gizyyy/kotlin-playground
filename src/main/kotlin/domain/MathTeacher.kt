package domain

import java.util.Random

class MathTeacher(
    override var studentList: MutableList<Student>,
    override var name: String,
    override var lesson: Lesson
) : Teacher {
    override fun giveNote(student: Student) {
        var wtf = Random()
        student.receiveNote(Note(Lesson.MATH, wtf.nextInt(10), "comments will be given to parents"))
    }

    override fun acceptStudent(student: Student) {
        super.acceptStudent(student)
        println("Welcome to my math lessons ${student.name}")
    }


}