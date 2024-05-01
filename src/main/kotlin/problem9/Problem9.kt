package problem9

class Solution {
    fun isPalindrome(x: Int): Boolean {
        var reverted = 0
        var a = x
        var count = 0
        while (a > 0){
            count++
            a /= 10
        }
        a = x
        for (i in 0 until count){
            reverted = reverted * 10 + a % 10
            a /= 10
        }
        return x == reverted
    }
}