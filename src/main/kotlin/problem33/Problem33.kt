package problem33

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex

        if (nums.size == 1)
            return if (nums[0] == target) 0 else -1

        var rotate: Int? = null
        while (l < r) {
            var middle = (l + r) / 2
            if (nums[middle] > nums[middle + 1]) {
                rotate = middle
                break
            } else if (nums[middle] < nums[nums.lastIndex]) {
                r = middle - 1
            } else {
                l = middle + 1
            }
        }

        if (l + 1 < nums.size && nums[l] > nums[l + 1])
            rotate = l

        return if (rotate == null) {
            binarySearch(nums, target, 0, nums.lastIndex)
        } else {
            maxOf(
                binarySearch(nums, target, 0, rotate),
                binarySearch(nums, target, rotate + 1, nums.lastIndex))
        }

    }

    fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
        var l = left
        var r = right
        while (l <= r) {
            var middle = (l + r) / 2
            if (nums[middle] == target) {
                return middle
            } else if (nums[middle] < target) {
                l = middle + 1
            } else {
                r = middle - 1
            }
        }
        return -1
    }
}