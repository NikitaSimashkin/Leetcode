package problem525

class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        var max = 0
        var cur = 0
        map[0] = - 1
        for (i in nums.indices){
            cur += if (nums[i] == 1) 1 else -1
            if (map.contains(cur)){
                max = maxOf(max, i - map[cur]!!)
            } else {
                map[cur] = i
            }
        }
        return max
    }
}