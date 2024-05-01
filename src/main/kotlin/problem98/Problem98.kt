package problem98

import TreeNode
import java.util.*

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        val queue = LinkedList<Triple<TreeNode, Long, Long>>()
        if (root == null) return true
        queue.add(Triple(root, Long.MIN_VALUE, Long.MAX_VALUE))
        while (queue.isNotEmpty()){
            val triple = queue.poll()
            val node = triple.first
            if (node.`val`.toLong() > triple.second && node.`val`.toLong()  < triple.third){
                if (node.right != null){
                    queue.add(Triple(node.right!!, node.`val`.toLong() , triple.third))
                }

                if (node.left != null){
                    queue.add(Triple(node.left!!, triple.second, node.`val`.toLong() ))
                }
            } else {
                return false
            }
        }
        return true
    }
}