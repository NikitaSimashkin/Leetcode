package problem108

import TreeNode

class Solution {
	fun sortedArrayToBST(nums: IntArray): TreeNode? {
		return sortedArrayToBST(nums, 0, nums.size)
	}

	fun sortedArrayToBST(nums: IntArray, start: Int, end: Int): TreeNode? {
		if (start >= end) return null
		if (end - start == 1) return TreeNode(nums[start])

		val middle = (end + start) / 2
		return TreeNode(nums[middle]).apply {
			left = sortedArrayToBST(nums, start, middle)
			right = sortedArrayToBST(nums, middle + 1, end)
		}
	}
}