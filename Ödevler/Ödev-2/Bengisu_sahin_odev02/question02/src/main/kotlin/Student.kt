// Since it is called database representation, data class was regarded as appropriate.
data class Student(
    val name: String,
    val no: Long,
    // Students' lessons were represented by "Set" because writing the same course more than once was to be prevented.
    val lessons: Set<String>
)
