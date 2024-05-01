package problem374

abstract class GuessGame{

    abstract fun guessNumber(n: Int): Int
}

class Solution:GuessGame() {
    val pick = 1702766719

    override fun guessNumber(n:Int):Int {
        var l = 0L
        var r = n.toLong()
        while (l < r){
            val middle: Long = ((l + r)/2)
            val value = guess(middle.toInt())
            if (value == 0)
                return middle.toInt()
            else if (value > 0)
                l = (middle + 1)
            else
                r = (middle - 1)
            println(middle)
        }
        return if (guess(l.toInt()) == 0)
            l.toInt()
        else
            -1
    }

    private fun guess(n: Int): Int{
        return pick - n
    }
}

fun main(){
    for (i in 2126753390..2126753390){
        println(Solution().guessNumber(i))
    }
}