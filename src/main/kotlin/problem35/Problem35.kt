package problem35

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target)
    }

    fun binarySearch(nums: IntArray, target: Int): Int{
        var l = 0
        var r = nums.lastIndex
        while (l <= r){
            val middle = (l + r)/2
            if (nums[middle] == target)
                return middle
            if (nums[middle] > target)
                r = middle - 1
            else
                l = middle + 1
        }
        if (l == nums.size)
            return nums.size
        return if (nums[l] > target) l else l + 1
    }
}