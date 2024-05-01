package problem238

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size){1}
        for (i in 1 until nums.size){
            answer[i] = answer[i - 1] * nums[i - 1]
        }
        var cur = 1
        for (i in nums.lastIndex - 1 downTo 0){
            cur *= nums[i + 1]
            answer[i] = answer[i] * cur
        }
        return answer
    }
}