import java.util.Scanner

fun main() {
    val input = Scanner(System.`in`)
    println("Enter string: ")
    val inputStr = input.nextLine()
    countFrequency(inputStr)
}

fun countFrequency(inputStr: String) {
    for (i in inputStr.indices) {
        var count = 0
        for (j in i until inputStr.length) {
            if (inputStr[i] == inputStr[j]) {
                count++
            }
        }
        // Check if this character is already counted
        var alreadyCounted = false
        for (k in 0 until i) {
            if (inputStr[k] == inputStr[i]) {
                alreadyCounted = true
                break
            }
        }
        if (!alreadyCounted) {
            println("'${inputStr[i]}' occurs $count times")
        }
    }
}
