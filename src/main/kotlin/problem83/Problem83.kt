package problem83

import ListNode

class Solution {
    fun deleteDuplicates2(head: ListNode?): ListNode? {
        val set = hashSetOf<Int>()
        if (head?.next == null) return head
        var cur = head.next
        set.add(head.`val`)
        var last = head
        while (cur != null){
            if (set.contains(cur.`val`)){
                last?.next = cur.next
            } else {
                set.add(cur.`val`)
                last = cur
            }
            cur = cur.next
        }
        return head
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        var current = head
        while (current != null){
            while (current.`val` == current.next?.`val`)
                current.next = current.next?.next
            current = current.next
        }
        return head
    }
}