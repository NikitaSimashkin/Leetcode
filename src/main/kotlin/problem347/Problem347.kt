package problem347

import java.util.*

fun <T> swap(array: MutableList<T>, one: Int, two: Int){
    val temp = array[two]
    array[two] = array[one]
    array[one] = temp
}

fun main(){
    val arr = intArrayOf(2,3,4,1,4,0,4,-1,-2,-1)
    println(Solution().topKFrequent(arr, 2).contentToString())
}

class Solution {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (i in nums){
            map[i] = map.getOrDefault(i, 0) + 1
        }

        val pairs = ArrayList<Pair<Int, Int>>(nums.size)
        for (i in map){
            pairs.add(i.key to i.value)
        }
        quickSort(pairs, 0, pairs.lastIndex, k)
        println(pairs)
        val ans = IntArray(k){0}
        for (i in 0 until k)
            ans[i] = pairs[pairs.lastIndex - i].first
        return ans
    }

    fun quickSort(nums: ArrayList<Pair<Int, Int>>, L: Int, R: Int, k: Int){
        if (R - L <= 0) return

        var l = L
        var r = R
        val middle = nums[(l + r)/2]
        while (l <= r){
            while (nums[l].second < middle.second)
                l++
            while (nums[r].second > middle.second)
                r--
            if (l <= r){
                swap(nums, l, r)
                l++
                r--
            }
        }
        if (nums.size - k > l){
            quickSort(nums, l, R, k)
        } else{
            quickSort(nums, L, r, k)
        }
    }

    fun topKFrequent2(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (i in nums){
            map[i] = map.getOrDefault(i, 0) + 1
        }

        val queue = PriorityQueue { o1: Pair<Int, Int>, o2: Pair<Int, Int> ->
            o1.second - o2.second
        }
        for (i in map){
            queue.add(i.key to i.value)
            if (queue.size > k){
                queue.poll()
            }
        }
        val res = IntArray(k){0}
        for (i in 0 until k){
            res[i] = queue.poll().first
        }
        return res
    }
}