package problem46

class Solution {
	fun permute(nums: IntArray): List<List<Int>> {
		if (nums.size == 1) return listOf(nums.toList())

		val ans = mutableListOf<List<Int>>()
		permute(nums, listOf(), ans)
		return ans
	}

	fun permute(nums: IntArray, current: List<Int>, result: MutableList<List<Int>>) {
		if (nums.size == current.size) {
			result.add(current)
			return
		}
		for (i in nums) {
			if (i in current) continue
			val currentArray = current.toMutableList()
			currentArray.add(i)
			permute(nums, currentArray, result)
		}
	}
}