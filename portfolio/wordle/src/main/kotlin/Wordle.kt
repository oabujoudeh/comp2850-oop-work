// Implement the six required functions here
fun isValid(word: String): Boolean {
    return word.length == 5 && word.all { it.isLetter() }
}

fun readWordList(filename: String): MutableList<String> =
    java.io.File(filename).readLines().toMutableList()

fun pickRandomWord(words: MutableList<String>): String {
    val word = words.random()
    words.remove(word)
    return word
}

fun obtainGuess(attempt: Int): String {
    while (true) {
        print("Attempt $attempt: ")   // stays on same line
        val guess = readln().trim().lowercase()

        if (isValid(guess)) {
            return guess
        } else {
            println("Invalid guess, choose a 5-letter word.")
        }
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = mutableListOf<Int>{
        for (i in 0..4){
            (if guess[i] == target[i]){
                return.add(1)
            }
            else{
                return.add(0)
            }
            
        }
    }
    return result
}








