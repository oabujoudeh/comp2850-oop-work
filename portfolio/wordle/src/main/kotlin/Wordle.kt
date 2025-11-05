// Implement the six required functions here
const val WORD_LENGTH = 5

fun isValid(word: String): Boolean {
    return word.length == WORD_LENGTH && word.all { it.isLetter() }
}

fun readWordList(filename: String): MutableList<String> =
    java.io.File(filename).readLines().toMutableList()

fun pickRandomWord(words: MutableList<String>): String {
    val word = words.random()
    words.remove(word)
    return word.lowercase()
}

fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: ")
        val guess = readln().trim().lowercase()

        if (isValid(guess)) {
            return guess
        } else {
            println("Invalid guess, choose a 5-letter word.")
        }
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = mutableListOf<Int>()
    val g = guess.trim().lowercase()
    val t = target.trim().lowercase()
    for (i in 0 until WORD_LENGTH) {
        if (g[i] == t[i]) {
            result.add(1)
        } else {
            result.add(0)
        }
    }
    return result
}

fun displayGuess(guess: String, matches: List<Int>) {
    var result = ""
    val g = guess.trim().lowercase()
    for (i in 0 until WORD_LENGTH) {
        if (matches[i] == 1) {
            result += g[i]
        } else {
            result += '?'
        }
    }
    println(result)
}
