fun main() {
    println("PIZZA MENU")
    println("(a) Margherita")
    println("(b) Quattro Stagioni")
    println("(c) Seafood")
    println("(d) Hawaiian")

    print("\nChoose your pizza (a–d): ")
    val choice = readln().lowercase()

    // Check if the input is valid:
    // - it must be exactly 1 character long
    // - that character must be in the range 'a'..'d'
    if (choice.length == 1 && choice[0] in 'a'..'d') {
        println("Order accepted")
    } else {
        println("Invalid choice!")
    }
}
