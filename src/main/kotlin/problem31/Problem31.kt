package problem31

class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        var cur = nums.lastIndex - 1
        while (cur >= 0){
            if (nums[cur] >= nums[cur + 1]){
                cur--
            } else {
                break
            }
        }
        if (cur >= 0){
            var min = nums.lastIndex
            for (i in cur + 1 until nums.size){
                if (nums[i] <= nums[cur]){
                    min = i - 1
                    break
                }
            }
            swap(nums, cur, min)
        }
        var start = cur + 1
        var end = nums.lastIndex
        while (start < end){
            swap(nums, start, end)
            start++
            end--
        }
    }

    fun swap(nums: IntArray, one: Int, two: Int){
        val temp = nums[one]
        nums[one] = nums[two]
        nums[two] = temp
    }
}