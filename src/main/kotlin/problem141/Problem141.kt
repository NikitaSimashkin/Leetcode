package problem141

import ListNode


fun hasCycle(head: ListNode?): Boolean {
    val set = HashSet<ListNode>()
    var cur = head
    while(cur != null){
        if (set.contains(cur))
            return false
        else
            set.add(cur)
        cur = cur.next
    }

    return true
}

fun hasCycle2(head: ListNode?): Boolean {
    var slow: ListNode? = null
    var fast: ListNode? = null
    while(true){
        if (fast?.next == null) return false
        fast = fast.next
        if (fast?.next == null) return false
        fast = fast!!.next
        slow = slow!!.next
        if (slow === fast)
            return true
    }
}