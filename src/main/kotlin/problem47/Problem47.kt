package problem47

import java.util.Stack

class Solution {
	fun permuteUnique(nums: IntArray): List<List<Int>> {
		val stack = Stack<Pair<List<Int>, List<Int>>>()

		for (i in nums) {
			stack.push(listOf(i) to nums.toMutableList().apply { remove(i) })
		}

		val result = mutableSetOf<List<Int>>()
		while(stack.isNotEmpty()) {
			val (cur, lost) = stack.pop()
			if (lost.isEmpty()) {
				result.add(cur)
				continue
			}
			for (i in lost) {
				val newList = cur.toMutableList()
				newList.add(i)
				stack.push(newList to lost.toMutableList().apply { remove(i) })
			}
		}

		return result.toList()
	}
}