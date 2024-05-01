package problem153

class Solution {
    fun findMin(nums: IntArray): Int {

        if ((nums.size == 1) || (nums[0] < nums.last())) return nums[0]
        var l = 0
        var r = nums.lastIndex
        while (l <= r){
            val middle = (l + r)/2
            if (nums[middle] > nums[middle + 1]){
                return nums[middle + 1]
            } else if (nums[l] <= nums[middle]){
                l = middle + 1
            } else {
                r = middle - 1
            }
        }

        return - 1
    }

    fun findMin2(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex
        while (l < r){
            val middle = l + (r - l)/2
            if (nums[r] < nums[middle]) l = middle + 1
            else r = middle
        }
        return nums[l]
    }
}