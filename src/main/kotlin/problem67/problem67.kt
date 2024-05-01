package problem67

class Solution {
    fun addBinary(a: String, b: String): String {
        val answer = StringBuilder()
        val max = if (a.length > b.length) a else b
        val min = if (max == a) b else a
        var ost = 0
        for (i in 0..max.lastIndex){
            if (min.lastIndex - i >= 0){
                val sum = min[min.lastIndex - i].charToInt() + max[max.lastIndex - i].charToInt() + ost
                answer.append(sum % 2)
                ost = sum/2
            } else {
                val sum = max[max.lastIndex - i].charToInt() + ost
                answer.append(sum % 2)
                ost = sum/2
            }
        }
        if (ost != 0)
            answer.append(ost)
        return answer.reverse().toString()

    }

    fun Char.charToInt(): Int = this - '0'
}