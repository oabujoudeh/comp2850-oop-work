const val MAX_ATTEMPTS = 10

fun main() {
    val words = readWordList("data/words.txt")
    if (words.isEmpty()) {
        println("Error: Word list is empty.")
        return
    }
    val target = pickRandomWord(words)

     for (attempt in 1..MAX_ATTEMPTS) {
        val guess = obtainGuess(attempt)
        val matches = evaluateGuess(guess, target)

        displayGuess(guess, matches)

        if (matches.all { it == 1 }) {
            println("Correct! You guessed the word in $attempt attempts.")
            return
        }
     }
     println("Out of guesses! The word was: $target")    
}
