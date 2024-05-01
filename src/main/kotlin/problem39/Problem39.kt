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

	fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
		val current = mutableListOf<Int>()
		val result = mutableListOf<List<Int>>()

		fun combinationSum(index: Int, currentSum: Int) {
			if (currentSum == target) {
				result.add(current.toList())
				return
			} else if (currentSum > target) {
				return
			}
			for (i in index until candidates.size) {
				current.add(candidates[i])
				combinationSum(i, currentSum + candidates[i])
				current.removeAt(current.size - 1)
			}
		}
		combinationSum(0, 0)
		return result
	}
}