package problem239

import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val window = ArrayList<Int>(k)
        for (i in 0 until k){
            window[i] = nums[i]
        }
        quickSort(window, 0, window.lastIndex)
        val answer = IntArray(k)
        answer[0] = window.last()
        var cur = 1
        for (i in k until window.size){
            window.remove(nums[i - k])
            window.add(binarySearch(window, nums[i]), nums[i])
            answer[cur] = window.last()
            cur++
        }
        return answer
    }

    fun binarySearch(nums: MutableList<Int>, target: Int): Int{
        var l = 0
        var r = nums.lastIndex
        while (l < r){
            val middle = (l + r)/2
            if (target == nums[middle])
                return middle
            if (target > nums[middle])
                l = middle + 1
            else
                r = middle - 1
        }
        if (target > nums[l])
            return l + 1
        return l
    }

    fun quickSort(nums: MutableList<Int>, L: Int, R: Int){
        if (R - L <= 0) return

        var l = L
        var r = R
        val middle = nums[(l + r)/2]
        while (l <= r){
            while (nums[l] < middle)
                l++
            while (nums[r] > middle)
                r--
            if (l <= r){
                val temp = nums[l]
                nums[l] = nums[r]
                nums[r] = temp
                l++
                r--
            }
        }

        quickSort(nums, l, R)
        quickSort(nums, L, r)
    }

    fun maxSlidingWindow1(nums: IntArray, k: Int): IntArray {
        val heap = PriorityQueue<Pair<Int, Int>>{o1: Pair<Int, Int>, o2: Pair<Int, Int> ->
            if (o2.first - o1.first != 0)
                o2.first.compareTo(o1.first)
            else {
                o2.second.compareTo(o1.second)
            }
        }
        val ans = IntArray(nums.size - k + 1)
        for (i in 0 until k){
            heap.add(nums[i] to i)
        }
        ans[0] = heap.peek().first
        var cur = 1
        for (i in k until nums.size){
            while (heap.isNotEmpty() && heap.peek().second <= i - k)
                heap.poll()
            heap.add(nums[i] to i)
            while (heap.isNotEmpty() && heap.peek().first < nums[i])
                heap.poll()
            ans[cur] = heap.peek().first
            cur++
        }
        return ans
    }
}