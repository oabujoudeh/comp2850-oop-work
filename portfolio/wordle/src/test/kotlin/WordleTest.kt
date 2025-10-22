import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({

    // Tests for isValid
    "isValid should return true for a word with 5 letters" {
        isValid("hello") shouldBe true
    }

    "isValid should return false for words less than 5 letters" {
        isValid("man") shouldBe false
    }

    "isValid should return false for words greater than 5 letters" {
        isValid("madrid") shouldBe false
    }

    "isValid should return false for words with numbers or symbols" {
        isValid("hel1o") shouldBe false
        isValid("hel!o") shouldBe false
    }

    // Tests for readWordList
    "readWordList should read wordle target words from the words.txt file, returning them as a list of strings" {
        val words = readWordList("data/words.txt")

        withClue("List should not be empty") {
            words.isNotEmpty() shouldBe true
        }

        withClue("List should be mutable") {
            words.removeAt(0)
            words.isNotEmpty() shouldBe true
        }

        withClue("Words should be of length 5") {
            words.all { it.length == 5 } shouldBe true
        }
    }

    // Tests for pickRandomWord
    "pickRandomWord should return a word from the list and remove it" {
        val words = mutableListOf("hello", "water", "world") // all 5 letters

        val chosen = pickRandomWord(words)

        (chosen == "hello" || chosen == "water" || chosen == "world") shouldBe true
        words.contains(chosen) shouldBe false
        words.size shouldBe 2
    }

    // Tests for evaluateGuess
    "evaluateGuess should return all 1s when guess matches target" {
        val result = evaluateGuess("hello", "hello")
        result shouldBe listOf(1, 1, 1, 1, 1)
    }

    "evaluateGuess should return all 0s when guess has no matches" {
        val result = evaluateGuess("hello", "water")
        result shouldBe listOf(0, 0, 0, 0, 0)
    }

    "evaluateGuess should mark only matching positions with 1" {
        val result = evaluateGuess("hello", "house")
        result shouldBe listOf(1, 0, 0, 0, 0)
    }
})
