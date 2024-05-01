package problem234

import ListNode

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var length = 0
        var cur = head
        while (cur != null){
            length++
            cur = cur.next
        }
        var center = head
        for (i in 0 until length/2 - 1){
            center = center?.next
        }
        if (length % 2 == 1){
            center = center?.next
        }
        var last = center
        cur = last?.next
        var third: ListNode?
        while(cur != null){
            third = cur.next
            cur.next = last
            last = cur
            cur = third
        }
        cur = head
        for (i in 0 until length/2){
            if (cur != null && last != null && cur.`val` != last.`val`)
                return false
            cur = cur?.next
            last = last?.next
        }
        return true
    }
}