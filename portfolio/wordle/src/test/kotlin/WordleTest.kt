import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    // --- Tests for isValid ---
    "isValid should return true for a valid 5-letter word" {
        isValid("apple") shouldBe true
    }

    "isValid should return false for words shorter than 5 letters" {
        isValid("dog") shouldBe false
    }

    "isValid should return false for words longer than 5 letters" {
        isValid("bananas") shouldBe false
    }

    "isValid should return false for words with numbers or symbols" {
        isValid("appl3") shouldBe false
        isValid("ap!le") shouldBe false
    }
})
