package problem112

import TreeNode
import java.util.Stack

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false

        val stack = Stack<Pair<TreeNode, Int>>()
        stack.push(root to root.`val`)

        while(stack.isNotEmpty()) {
            val current = stack.pop()
            val node = current.first

            if (node.right == null && node.left == null && current.second == targetSum) {
                return true
            }

            if (node.right != null) {
                stack.push(node.right to (current.second + node.right.`val`))
            }
            if (node.left != null) {
                stack.push(node.left to (current.second + node.left.`val`))
            }
        }

        return false
    }
}