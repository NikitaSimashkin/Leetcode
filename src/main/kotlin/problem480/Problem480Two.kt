package problem480

import java.util.*

class Solution1 {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val low = PriorityQueue<Int>()
        val high = PriorityQueue<Int>(Collections.reverseOrder())
        for (i in 0 until k){
            low.add(nums[i])
        }
        for (i in 0 until k/2){
            high.add(low.poll())
        }
        val countMedian = if (k % 2 == 0) {lowHeap: PriorityQueue<Int>, highHeap: PriorityQueue<Int> ->
            ((lowHeap.peek().toLong() + highHeap.peek().toLong())/2.toDouble())
        } else {lowHeap: PriorityQueue<Int>, highHeap: PriorityQueue<Int> ->
            if (lowHeap.size > highHeap.size)
                lowHeap.peek().toDouble()
            else
                highHeap.peek().toDouble()
        }
        val answer = mutableListOf<Double>()
        answer.add(countMedian(low, high))
        for (i in k until nums.size){
            if (low.contains(nums[i-k]))
                low.remove(nums[i - k])
            else
                high.remove(nums[i - k])

            if (low.isEmpty() || nums[i] > low.peek())
                low.add(nums[i])
            else
                high.add(nums[i])

            this.check(low, high)
            answer.add(countMedian(low, high))
        }
        return answer.toDoubleArray()
    }

    private fun check(low: PriorityQueue<Int>, high: PriorityQueue<Int>) {
        while (low.size - high.size > 1 ||
            high.isNotEmpty() && low.isNotEmpty() && low.peek() < high.peek()){
            high.add(low.poll())
        }
        while (high.size - low.size > 1 || high.isNotEmpty() && low.isNotEmpty() && low.peek() < high.peek()){
            low.add(high.poll())
        }
    }
}