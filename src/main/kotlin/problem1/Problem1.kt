package problem1

class Solution {


    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (i in nums.indices){
            if (map.contains(target - nums[i]))
                return intArrayOf(map[target-nums[i]]!!, i)
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}