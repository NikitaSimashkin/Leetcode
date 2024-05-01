package problem543

import TreeNode

class Solution {
    var answer = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0
        count(root)
        return answer
    }

    fun count(root: TreeNode?): Int {
        if (root == null) return 0
        val left = count(root.left)
        val right = count(root.right)
        answer = maxOf(answer, left + right)
        return maxOf(left, right) + 1
    }
}