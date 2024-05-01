package problem66

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        digits[digits.lastIndex] = digits[digits.lastIndex] + 1
        for (i in digits.lastIndex downTo 1){
            if (digits[i] == 10){
                digits[i] = 0
                digits[i - 1] = digits[i - 1] + 1
            } else {
                break
            }
        }
        if (digits[0] == 10){
            val res = IntArray(digits.size + 1)
            res[0] = 1
            res[1] = 0
            for (i in 1 until digits.size){
                res[i + 1] = digits[i]
            }
            return res
        } else {
            return digits
        }
    }
}