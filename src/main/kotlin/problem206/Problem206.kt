package problem206

import ListNode

class Solution {
    fun reverseList(head: ListNode?): ListNode? {

        var previous = head
        var current = head?.next
        var next = head?.next?.next
        previous?.next = null

        while(current != null){
            current.next = previous
            previous = current
            current = next
            next = current?.next
        }
        return previous
    }

    //============================================//

    fun reverseList2(head: ListNode?): ListNode? {
        return reverse(null, head)
    }

    fun reverse(one: ListNode?, two: ListNode?): ListNode?{
        if (two == null)
            return one
        val three = two.next
        two.next = one
        return reverse(two, three)
    }


    // https://www.youtube.com/watch?v=jqZPEfAbc2s
    fun reverseList3(head: ListNode?): ListNode? {
        if (head?.next == null)
            return head

        val ans = reverseList3(head.next)
        head.next?.next = head
        head.next = null
        return ans
    }
}