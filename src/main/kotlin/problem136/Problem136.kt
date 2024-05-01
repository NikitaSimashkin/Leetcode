package problem136

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var sum = 0
        for (i in nums)
            sum = sum xor i
        return sum
    }
}