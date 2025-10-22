// Implement the six required functions here
fun isValid(word: String): Boolean {
    return word.length == 5 && word.all { it.isLetter() }
}

fun readWordList(words.txt: String): MutableList<String> =
    java.io.File(words.txt).readLines().toMutableList()






