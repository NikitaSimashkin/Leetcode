package problem103

import TreeNode
import java.util.*

class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        val answer = mutableListOf<MutableList<Int>>()
        var counter = 0
        while (queue.isNotEmpty()){
            val level = mutableListOf<Int>()
            for (i in 0 until queue.size){
                val cur = queue.poll()
                if (cur != null){
                    level.add(cur.`val`)
                    queue.add(cur.left)
                    queue.add(cur.right)
                }
            }
            if (counter % 2 == 1)
                level.reverse()
            counter++
            if (level.isNotEmpty())
                answer.add(level)
        }
        return answer

    }
}