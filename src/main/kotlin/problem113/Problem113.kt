package problem113

import TreeNode

class Solution {
    var target: Int = 0

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) return emptyList()
        target = targetSum
        val list = mutableListOf<List<Int>>()
        count(root, 0, list, mutableListOf())
        return list
    }

    fun count(root: TreeNode?, cur: Int, list: MutableList<List<Int>>, curList: MutableList<Int>) {
        if (root == null) return
        curList.add(root.`val`)
        if (root.left == null && root.right == null){
            if (target == cur + root.`val`){
                list.add(ArrayList<Int>(curList))
            }
        } else {
            count(root.left, cur + root.`val`, list, curList)
            count(root.right, cur + root.`val`, list, curList)
        }
        curList.removeAt(curList.lastIndex)
    }
}