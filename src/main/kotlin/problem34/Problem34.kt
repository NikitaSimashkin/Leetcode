package problem34

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(leftBinarySearch(nums,target), rightBinarySearch(nums, target))
    }

    fun leftBinarySearch(nums: IntArray, target: Int): Int{
        var l = 0
        var r = nums.lastIndex
        while (l <= r){
            val middle = (l + r)/2
            if (nums[middle] == target && (middle == 0 || nums[middle - 1] != target))
                return middle
            else if (nums[middle] < target)
                l = middle + 1
            else
                r = middle - 1
        }
        return -1
    }

    fun rightBinarySearch(nums: IntArray, target: Int): Int{
        var l = 0
        var r = nums.lastIndex
        while (l <= r){
            val middle = (l + r)/2
            if (nums[middle] == target && (middle == nums.lastIndex || nums[middle + 1] != target))
                return middle
            else if (nums[middle] <= target)
                l = middle + 1
            else
                r = middle - 1
        }
        return -1
    }
}