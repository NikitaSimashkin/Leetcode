package problem101

import TreeNode
import java.util.*
import kotlin.math.abs

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSymmetric(root?.left, root?.right)
    }

    fun isSymmetric(one: TreeNode?, two: TreeNode?):Boolean{
        var firstCheck = true
        var secondCheck = true
        if (one?.`val` != two?.`val`) return false

        if (one?.left != null || two?.right != null)
            firstCheck = isSymmetric(one?.left, two?.right)

        if (one?.right != null || two?.left != null)
            secondCheck = isSymmetric(one?.right, two?.left)

        return firstCheck && secondCheck
    }

    fun isSymmetric2(root: TreeNode?): Boolean {
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root?.left)
        queue.add(root?.right)

        while(queue.isNotEmpty()){
            val one = queue.poll()
            val two = queue.poll()
            if (one?.`val` != two?.`val`) return false

            if (one?.left != null || two?.right != null){
                queue.add(one?.left)
                queue.add(two?.right)
            }
            if (one?.right != null || two?.left != null){
                queue.add(one?.right)
                queue.add(two?.left)
            }
        }
        return true
    }
}