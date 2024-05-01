package problem33

class Solution2 {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex

        if (nums.size == 1)
            return if (nums[0] == target) 0 else -1

        while (l <= r){
            val middle = (l + r)/2
            if (nums[middle] == target) return middle
            if (nums[l] <= nums[middle]){
                if (nums[l] <= target && target < nums[middle]){
                    r = middle - 1
                } else {
                    l = middle + 1
                }
            } else {
                if (nums[middle] < target && target <= nums[r]){
                    l = middle + 1
                } else {
                    r = middle - 1
                }
            }
        }

        return -1
    }
}