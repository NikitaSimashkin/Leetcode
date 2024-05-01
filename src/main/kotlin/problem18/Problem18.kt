package problem18

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if (nums.size < 4)
            return emptyList()

        nums.sort()
        val answerSet = hashSetOf<List<Int>>()
        for (i in 0..nums.size - 4){
            for (j in i+1..nums.size - 3){
                var l = j + 1
                var r = nums.lastIndex
                while (l < r){
                    val sum: Long = nums[i].toLong() + nums[j] + nums[l] + nums[r]
                    if (sum == target.toLong()) {
                        answerSet.add(listOf(nums[i], nums[j], nums[l], nums[r]))
                        l++
                        r--
                    } else if (sum < target){
                        l++
                    } else {
                        r--
                    }
                }
            }
        }
        return answerSet.toList()
    }
}