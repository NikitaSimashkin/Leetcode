package problem480

import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val window = ArrayList<Int>(k)
        for (i in 0 until k) {
            window.add(nums[i])
        }
        quickSort(window, 0, window.lastIndex)
        val ans = mutableListOf<Double>()
        val median: (ArrayList<Int>) -> Double =
            if (k % 2 == 0)
                { a: ArrayList<Int> -> (a[a.size / 2].toDouble() + a[a.size/2 - 1].toDouble()) / 2}
            else
                { a: ArrayList<Int> -> (a[a.size / 2]).toDouble() }

        ans.add(median(window))
        for (i in k until nums.size){
            window.remove(nums[i - k])
            window.add(binarySearch(window, nums[i]), nums[i])
            ans.add(median(window))
        }
        return ans.toDoubleArray()
    }

    fun quickSort(array: MutableList<Int>, L: Int, R: Int) {
        if (R - L <= 0) return

        val middle = array[(L + R) / 2]
        var l = L
        var r = R
        while (l <= r) {
            while (array[l] < middle)
                l++
            while (array[r] > middle)
                r--
            if (l <= r) {
                val temp = array[r]
                array[r] = array[l]
                array[l] = temp
                l++
                r--
            }
        }
        quickSort(array, L, r)
        quickSort(array, l, R)
    }

    fun binarySearch(nums: MutableList<Int>, target: Int): Int {
        if (nums.size == 0) return 0
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            val middle = (l + r) / 2
            if (target == nums[middle])
                return middle
            else if (target > nums[middle]) {
                l = middle + 1
            } else {
                r = middle - 1
            }
        }
        if (target > nums[l]){
            return l + 1
        }
        return l
    }
}