package problem24

import ListNode

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val newHead = head.next
        var currentNode = head
        while (currentNode != null){
            val second = currentNode.next
            val third = second?.next
            currentNode.next = third?.next ?: third
            second?.next = currentNode
            currentNode = third
        }
        return newHead
    }
}