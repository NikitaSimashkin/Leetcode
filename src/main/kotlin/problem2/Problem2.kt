package problem2

import ListNode

fun main(){

}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var one = l1
        var two = l2
        val head = ListNode(0)
        var curNode = head
        var ost = 0
        while(!(one == null && two == null)){
            if (one == null){
                val sumNode = two!!.`val` + ost
                ost = sumNode/10
                curNode.next = ListNode(sumNode - (ost * 10))
                two = two.next
            } else if (two == null){
                val sumNode = one.`val` + ost
                ost = sumNode/10
                curNode.next = ListNode(sumNode - (ost * 10))
                one = one.next
            } else {
                val sumNode = one.`val` + two.`val` + ost
                ost = sumNode/10
                curNode.next = ListNode(sumNode - (ost * 10))
                one = one.next
                two = two.next
            }
            curNode = curNode.next!!
        }
        if (ost != 0)
            curNode.next = ListNode(ost)
        return head.next
    }
}