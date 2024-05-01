package problem100

import TreeNode
import java.util.*

class Solution {
    fun check(p: TreeNode?, q: TreeNode?): Boolean {
        return p?.`val` == q?.`val`
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (!check(p, q))
            return false
        var first: Boolean = true
        var second: Boolean = true
        if (p?.left != null || q?.left != null)
            first = isSameTree(p?.left, q?.left)

        if (p?.right != null || q?.right != null)
            second = isSameTree(p?.right, q?.right)
        return first && second
    }

    fun isSameTree1(p: TreeNode?, q: TreeNode?): Boolean {
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(p)
        queue.add(q)
        while (queue.isNotEmpty()){
            var first = queue.poll()
            var second = queue.poll()
            if (first?.`val` != second?.`val`){
                return false
            } else {
                if (first?.left != null || second?.left != null) {
                    queue.add(first?.left)
                    queue.add(second?.left)
                }

                if (first?.right != null || second?.right != null) {
                    queue.add(first?.right)
                    queue.add(second?.right)
                }
            }
        }
        return true
    }
}