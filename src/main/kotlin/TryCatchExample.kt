import java.lang.Exception

class TryCatchExample(var a: Int, var b: Int) {
    // there is no checked exception in kotlin
    // try catch as expression
    var result: Double = try {
        divide()
    } catch (e: Exception) {
        0.0
    }

    @Throws(ArithmeticException::class)
    private fun divide(): Double {
        throw ArithmeticException()
        return 0.0
    }
}

fun main(args: Array<String>) {
    val tryCatchExample = TryCatchExample(3, 0)
    println(tryCatchExample.result)
}