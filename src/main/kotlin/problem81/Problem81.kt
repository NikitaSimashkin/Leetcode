package problem81

class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        var l = 0
        var r = nums.lastIndex
        if (nums.size == 1) return nums[0] == target
        if (nums[0] == nums.last()){
            for (i in nums)
                if (i == target)
                    return true
            return false
        }
        while (l <= r){
            val middle = l + (r - l)/2
            if (nums[middle] == target) return true
            if (nums[l] <= nums[middle]){
                if (nums[l] <= target && target < nums[middle])
                    r = middle - 1
                else
                    l = middle + 1
            } else {
                if (nums[middle] < target && target < nums[r])
                    l = middle + 1
                else
                    r = middle - 1
            }
        }
        return false
    }
}