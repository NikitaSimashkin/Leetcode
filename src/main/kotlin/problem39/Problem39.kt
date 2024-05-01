package problem39

import java.util.Stack

fun main(){
    Solution().combinationSum(intArrayOf(2,3,5,7), 10)
}

class Solution {
	fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
		val stack = Stack<Triple<List<Int>, Int, Int>>()

		for (i in candidates.indices) {
			stack.push(Triple(listOf(candidates[i]), candidates[i], i))
		}

		val result = mutableListOf<List<Int>>()
		while(stack.isNotEmpty()) {
			val (list, sum, lastIndex) = stack.pop()
			if (sum > target) continue
			if (sum == target) {
				result.add(list)
				continue
			}
			for (i in lastIndex until candidates.size) {
				val newList = list.toMutableList()
				newList.add(candidates[i])
				stack.push(Triple(newList, sum + candidates[i], i))
			}
		}

		return result
	}
}