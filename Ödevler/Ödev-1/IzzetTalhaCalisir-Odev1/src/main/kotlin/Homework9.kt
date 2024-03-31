package org.example

fun combine(dize1: String, dize2: String): String {
    return if (dize1.count { it.isLetter() } == dize2.count { it.isLetter() }) {
        dize1.uppercase() + dize2.uppercase()
    } else {
        dize1 + dize2
    }
}
