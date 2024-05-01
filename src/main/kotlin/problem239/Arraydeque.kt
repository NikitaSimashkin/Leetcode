package problem239

import java.util.*
import kotlin.collections.ArrayDeque

class Arraydeque {
    class Solution {
        fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
            if (nums.isEmpty()) return intArrayOf()
            val deque = ArrayDeque<Int>()
            for(i in 0 until k){
                addToDeque(deque, nums, i)
            }
            val answer = IntArray(nums.size - k + 1)
            var cur = 0
            answer[cur++] = nums[deque.first()]
            for (i in k until nums.size){
                addToDeque(deque, nums, i)
                while (deque.first() <= i - k){
                    deque.removeFirst()
                }
                answer[cur++] = nums[deque.first()]
            }
            return answer
        }

        private fun addToDeque(
            deque: ArrayDeque<Int>,
            nums: IntArray,
            index: Int
        ) {
            while (deque.isNotEmpty() && nums[deque.last()] < nums[index]) {
                deque.removeLast()
            }
            deque.addLast(index)
        }
    }
}

class Linkedlist{
    class Solution {
        fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
            if (nums.isEmpty()) return intArrayOf()
            val deque: Deque<Int> = LinkedList<Int>()
            for(i in 0 until k){
                addToDeque(deque, nums, i)
            }
            val answer = IntArray(nums.size - k + 1)
            var cur = 0
            answer[cur++] = nums[deque.first()]
            for (i in k until nums.size){
                addToDeque(deque, nums, i)
                while (deque.first() <= i - k){
                    deque.removeFirst()
                }
                answer[cur++] = nums[deque.first()]
            }
            return answer
        }

        private fun addToDeque(
            deque: Deque<Int>,
            nums: IntArray,
            index: Int
        ) {
            while (deque.isNotEmpty() && nums[deque.last()] < nums[index]) {
                deque.removeLast()
            }
            deque.addLast(index)
        }
    }
}