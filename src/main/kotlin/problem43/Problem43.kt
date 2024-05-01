package problem43

import kotlin.math.pow

fun main(){
    val one = "123"
    val two = "456"
    println(Solution().multiply(one, two))

    val o = StringBuilder(one)
    val t = StringBuilder(two)
    Solution().plusString(o, t, 0)
    println(o)

//    val s = Solution()
//    a@ for (i in 0..10)
//        for(j in 0..1000000){
//            val one = s.multiply(i.toString(), j.toString()).toInt()
//            val two = i * j
//            if (one != two){
//                println(i)
//                println(j)
//                break@a
//            }
//        }
}

class Solution {
    fun multiply(num1: String, num2: String): String {
        val res = StringBuilder("0")
        var offset = 0
        for (i in num2.lastIndex downTo 0){
            offset = num2.lastIndex - i
            for (j in num1.lastIndex downTo 0){
                val cur = num1[j].charToInt() * num2[i].charToInt()
                val adding = StringBuilder(cur.toString())
                plusString(res, adding, offset)
                offset++
            }
        }
        while (res.length > 1 && res[0] == '0')
            res.deleteCharAt(0)
        return res.toString()
    }

    fun plusString(res: StringBuilder, adding: StringBuilder, offset: Int) {
        var ost = 0
        var cur: Int
        var index = 0
        var counter = 0
        for (i in adding.lastIndex downTo 0) {
            if (res.lastIndex - index - offset >= 0) {
                cur = adding[i].charToInt() + res[res.lastIndex - index - offset].charToInt() + ost
                res[res.lastIndex - index - offset] = (cur % 10).intToChar()
            } else {
                cur = adding[i].charToInt() + ost
                res.insert(0, (cur % 10).intToChar())
                index++
            }
            ost = cur / 10
            index++
            counter++
        }
        if (ost != 0) {
            plusString(res, StringBuilder(ost.toString()), counter + offset)
        }
    }

    fun Char.charToInt(): Int = this - '0'
    fun Int.intToChar(): Char = (this + '0'.toInt()).toChar()
}