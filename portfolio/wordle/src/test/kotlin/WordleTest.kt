import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    //  Tests for isValid
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
    "readWordList should read wordle target words from the words.txt file, returning them as a list of strings"{
        val words = readWordList("data/words.txt")

        // make sure list is not empty
        withClue("List should not be empty"){
            words.isNotEmpty() shouldBe true
        }

        // make sure list is mutable

    }

})
