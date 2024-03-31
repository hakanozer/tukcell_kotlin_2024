package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


fun main() {
    //1
    val array = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val doubles = findDoubleNumbers(array)
    println("Double Numbers are: $doubles")
    //2
    val array2 = listOf('a', 'b', 'c', 'a', 'b', 'a', 'c', 'd', 'e', 'e')
    val frequencies = findWordFrequencies(array2)
    println("Word Frequencies: $frequencies")
    //3
    val originalList = listOf(1, 2, 3, 4, 5)
    val turnedList = turnOver(originalList)
    println("Original List is: $originalList")
    println("Turned list is: $turnedList")
    //4
    val starting = 1
    val finishing = 20
    val singles = createSingleNumberArray(starting, finishing)
    println("Single Numbers: $singles")
    //5
    val array3 = listOf('a', 'B', 'c', 'D', 'e', 'f', 'G', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'O', 'p', 'Q', 'r', 'S', 't', 'u', 'v', 'w', 'X', 'y', 'Z')
    val count = countVowelWordNumber(array3)
    println("Count of Vowel Words: $count")
    //6
    val n = 50
    val prList = findPrimeNumbers(n)
    println("Prime Numbers: $prList")
    //7
    val array4 = listOf("Merhaba", "dünya", "", "Kotlin", "programlama", "dili", "", "ile", "ilgileniyorum")
    val wordNumber = countWordNumber(array4)
    println("Word number: $wordNumber")
    //8
    val array5= listOf("Merhaba", "dünya", "Merhaba", "Kotlin", "programlama", "Merhaba", "dünya")
    val mostRepeatedWord = findMostRepeated(array5)
    println("Most Repeated Word is: $mostRepeatedWord")
    //9
    val dize1 = "Merhaba"
    val dize2 = "Dünya"
    println(combine(dize1, dize2))
    println(combine("abc", "def"))
    //10
    val list = listOf(1, 2, 3, 4, 5)
    val set = setOf(3, 4, 5, 6, 7)
    val difference = listSetDifference(list, set)
    println("Difference Between List and Set: $difference")
}