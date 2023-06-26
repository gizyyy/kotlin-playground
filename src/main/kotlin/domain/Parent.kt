package domain

class Parent {
    private var kid: Student? = null

    fun reviewNotes() {
        this.kid?.notes?.forEach { note: Note ->
            when (note.teacherOpinion) {
                is String -> println(note.teacherOpinion)
                is Int -> println("Note is ${note.teacherOpinion}")
            }
        }

    }
}