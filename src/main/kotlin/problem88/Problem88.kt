package problem88

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var one = m - 1
        var two = n - 1
        var last = m + n - 1
        while(two >= 0){
            if (one < 0 || nums2[two] > nums1[one]){
                nums1[last] = nums2[two]
                two--
                last--
            } else {
                nums1[last] = nums1[one]
                one--
                last--
            }
        }
    }
}