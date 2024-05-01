package problem704

import java.util.*

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex

        while (l <= r){
            val middle = (r + l)/2
            if (nums[middle] == target)
                return middle
            else if (nums[middle] < target)
                l = middle + 1
            else
                r = middle - 1
        }
        return -1
    }
}

fun main(){
    val size = 5
    val array = (0..size).map { Random().nextInt(20) }.toIntArray().sortedArray()
    println(array.toList())
    val ans = mutableListOf<Int>()
    for (i in 0..20+2){
        val search = Solution().search(array, i)
        if(search != -1){
            ans.add(search)
        }
    }
    println(ans)
}