import kotlin.math.roundToInt

fun main(args: Array<String>) {
    // Step 1: Check if exactly 3 arguments are provided
    if (args.size != 3) {
        println("Error: Please provide exactly three marks (0–100).")
        return
    }

    // Step 2: Convert arguments to integers
    val marks = args.map { it.toIntOrNull() }  // safely convert
    if (marks.any { it == null }) {
        println("Error: All marks must be valid integers.")
        return
    }

    // Step 3: Calculate average
    val average = marks.filterNotNull().average().roundToInt()

    // Step 4: Determine grade using when expression
    val grade = when (average) {
        in 70..100 -> "Distinction"
        in 40..69 -> "Pass"
        in 0..39 -> "Fail"
        else -> "Invalid marks"
    }

    // Step 5: Output result
    println("Average: $average")
    println("Grade: $grade")
}
