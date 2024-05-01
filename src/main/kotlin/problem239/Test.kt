package problem239

fun main(){

    val testArray = IntArray(100_000)
    val k = 50_000
    for (i in testArray.indices){
        testArray[i] = (i + 10)/10
    }

    //=======================================================================

    val s1 = Arraydeque.Solution()

    val startOne = System.currentTimeMillis()
    val arrayDequeResult = s1.maxSlidingWindow(testArray, k).contentToString()
    val endOne = System.currentTimeMillis()

    println(endOne - startOne)

    //=======================================================================

    val s2 = Linkedlist.Solution()

    val startTwo = System.currentTimeMillis()
    val linkedListResult = s2.maxSlidingWindow(testArray, k).contentToString()
    val endTwo = System.currentTimeMillis()

    println(endTwo - startTwo)
    println(linkedListResult == arrayDequeResult)
}