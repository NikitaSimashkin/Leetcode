package problem29

fun main() {
    println(Solution().divide(1100540749, -1090366779))
}

class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        if (divisor == Int.MIN_VALUE){
            return if (dividend == Int.MIN_VALUE)
                1
            else
                0
        }
        if (dividend == Int.MIN_VALUE && divisor == -1)
            return Int.MAX_VALUE
        if (divisor == 1) {
            return dividend
        } else if (divisor == -1){
            return -dividend
        }
        var res = 0
        var curPlus = 1

        var del = dividend
        var div = divisor

        var startedDivisor = divisor
        var oneNegative = false
        if (del < 0 && div < 0) {
            if (del == Int.MIN_VALUE){
                del -= div
                res += 1
            }
            startedDivisor = -divisor
            del = -del
        } else if (del < 0){
            if (del == Int.MIN_VALUE){
                del += div
                res += 1
            }
            del = -del
            oneNegative = true
        } else if (div < 0){
            startedDivisor = -divisor
            oneNegative = true
        }

        while (del >= 0) {
            div = startedDivisor
            curPlus = 1
            var flag = false
            println("$div $curPlus $del $res")
            while (div <= del && div < 0x3FFFFFFF) {
                flag = true
                div = div shl 1
                curPlus = curPlus shl 1
            }
            if (flag) {
                div = div shr 1
                curPlus = curPlus shr 1
            }
            res += curPlus
            del -= div
            println("$div $curPlus $del $res")
        }
        res -= curPlus

        if (oneNegative)
            return -res
        return res
    }
}