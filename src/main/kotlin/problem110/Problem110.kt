package problem110

import TreeNode
import kotlin.math.abs

class Solution {

    fun getHeight(root: TreeNode?): Int{
        if (root == null)
            return 0
        val left = getHeight(root.left)
        if (left == -1)
            return -1

        val right = getHeight(root.right)
        if (right == -1)
            return -1

        if (abs(left - right) > 1)
            return -1

        return maxOf(right, left) + 1
    }

    fun isBalanced(root: TreeNode?): Boolean {
        return getHeight(root) != -1
    }

    fun isBalanced2(root: TreeNode?): Boolean {
        if (root == null) return true

        return isBalanced2(root.left) && isBalanced2(root.right)
                && abs(count(root.left) - count(root.right)) <= 1
    }

    fun count(root: TreeNode?): Int {
        if (root == null) return 0
        return maxOf(count(root.left), count(root.right)) + 1
    }
}