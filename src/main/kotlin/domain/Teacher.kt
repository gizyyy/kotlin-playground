package domain

interface Teacher {
    var studentList: MutableList<Student>
    val name: String
    val lesson: Lesson

    fun giveNote(student: Student)

    //how we get functions as parameters in kotlin way
    fun giveExplanationOfNote(note: Int, explanationDueToSchoolSystem: (Int) -> String) {
        explanationDueToSchoolSystem(note)
    }

    fun acceptStudent(student: Student) {
        val foundStudent = studentList.any { s: Student -> student.id == s.id }
        if (foundStudent)
            return
        studentList.add(student);
    }

    // playing around with casting unnecessarily
    fun giveSomethingAboutPersonality(name: String): String {
        val specification: String
        val whoIAm: Any
        if (this is MathTeacher) {
            whoIAm = this
            specification = "I like numbers"
        } else {
            whoIAm = this as EnglishTeacher
            specification = "I like foreign language"
        }
        return specification
    }


    // kotlin way of one line function
    fun isEnglishTeacher(): Boolean =
        this is EnglishTeacher


    fun isMathTeacher(): Boolean = this is MathTeacher

    fun printType() =
        this::class.qualifiedName


}