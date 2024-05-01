import problem735.Problem735
import java.util.*


fun main(){
    Problem735().mergeKLists(arrayOf())
}


class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val head = ListNode(0)
        var current = head

        while (!lists.isEmpty()){
            val min = lists.getMin()
            current.next = ListNode(min)
            current = current.next!!
        }


        return head.next
    }

    fun Array<ListNode?>.isEmpty() = this.all { it == null }

    fun Array<ListNode?>.getMin(): Int{
        var minValue = Int.MIN_VALUE
        var minIndex = 0
        PriorityQueue<Int>().poll()

        for(i in indices) {
            val cur = this[i]
            if (cur != null && cur.`val` < minValue){
                minIndex = i
                minValue = cur.`val`
            }
        }
        set(minIndex, get(minIndex)?.next)
        return minValue
    }
}