package collectionsexample

fun main(args: Array<String>) {
    val stadium = Stadium("Gizem's Stadium")
    println(stadium);

//simple playground for functional programming

    var lowercaseLambda = { x: String -> x.lowercase() }
    val list = listOf<String>("some", "values", "are", "coming", "here")

    val newList = list.filter { it != "are" }.map { it.uppercase() }.forEach { x: String ->
        lowercaseLambda.invoke(x)
        //or lowercaseLambda.invoke(it)
    }

    val reduce = list.reduce { result, value -> result + value + "," }

    //immutable
    val map:Map<Int, String> = mapOf(3 to "three", 2 to "two")
    println(map.toString())

    //mutable
    var mapMu:MutableMap<Int, String>
    mapMu = HashMap<Int, String>()
    mapMu[3] = "three"
    mapMu[2] = "two"




}