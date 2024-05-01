package problem56

import kotlin.Comparator

fun main(){
    println(Solution().merge(arrayOf(
        intArrayOf(2, 3),
        intArrayOf(4, 5),
        intArrayOf(6, 7),
        intArrayOf(8, 9),
        intArrayOf(1, 10),)
    ).contentDeepToString())
}

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        quickSort(intervals, Comparator{ o1: IntArray, o2: IntArray -> o1[0] - o2[0] }, 0, intervals.size - 1)
        var cur = 0
        val res = ArrayList<IntArray>()
        while(cur < intervals.size){
            val start = intervals[cur][0]
            var end = intervals[cur][1]
            while(cur + 1 < intervals.size && end >= intervals[cur+1][0]){
                end = maxOf(end, intervals[cur + 1][1])
                cur++
            }
            res.add(intArrayOf(start, end))
            cur++
        }
        return res.toTypedArray()
    }


    fun <T> quickSort(array: Array<T>, comparator: Comparator<T>, left: Int, right: Int) {
        if (right - left <= 0) return

        var l = left
        var r = right

        val middle = array[(left + right)/2]
        while (l <= r){
            while (comparator.compare(array[l], middle) < 0){
                l++
            }
            while (comparator.compare(array[r], middle) > 0){
                r--
            }
            if (l <= r) {
                swap(array, l, r)
                l++
                r--
            }
        }
        quickSort(array, comparator, left, r)
        quickSort(array, comparator, l, right)
    }

    private fun <T> swap(array: Array<T>, one: Int, two: Int){
        val temp = array[two]
        array[two] = array[one]
        array[one] = temp
    }

    fun merge1(intervals: Array<IntArray>): Array<IntArray> {

        var cur = 0
        a@ while(true){
            if (intervals[cur][0] != -1){
                for (i in intervals.indices){
                    if (i != cur && intervals[cur][0] <= intervals[i][0] && intervals[cur][1] >= intervals[i][0]){
                        intervals[cur][1] = maxOf(intervals[cur][1], intervals[i][1])
                        intervals[i][0] = -1
                        continue@a
                    }
                }
            }
            if (cur == intervals.lastIndex)
                break
            cur++
        }
        return intervals.filter { it[0] != -1 }.toTypedArray()
    }
}