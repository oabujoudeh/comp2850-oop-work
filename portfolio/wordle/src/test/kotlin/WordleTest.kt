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
        withClue("List should be mutable "){
            words.removeAt(0)
            words.isNotEmpty() shouldBe true
        }

        // make sure the words are strings of length five
        withClue("Words should be of length 5"){
            words.all { it.length == 5 } shouldBe true

        }

    // Tests for pickRandomWord    
        //picks a random word and deletes it
        "pickRandomWord should return a word from the list and remove it"{

            val words = ["madrid","water","hello"]  //small list

            val chosen = pickRandomWord(words)

            // make sure the words are in the original list
            (chosen == "madrid"|| chosen == "water"|| chosen == "hello") shouldBe true

            // make sure chosen word is removed from original list
            words.contains(chosen) shouldBe false

            // original list size should decrease by one
            words.size() shouldBe 2
        }

        


    

        }

    }

})
