package problem692

import java.util.*

fun main(){
    val r = Random()
    val list = mutableListOf<Int>()
    val queue = PriorityQueue<Int>()
        //{ o1: Int, o2: Int -> o1-o2 }
    for (i in 0 until 10){
        list.add(r.nextInt(20))
    }
    println(list)

    for (i in 0 until 10){
        queue.add(list[i])
    }
    for (i in 0 until 10){
        println(queue.poll())
    }
}

class Solution {

    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val map = hashMapOf<String, Int>()
        val queue = PriorityQueue{o1: Pair<String, Int>, o2: Pair<String, Int> ->
            val sub = o1.second - o2.second
            if (sub != 0)
                return@PriorityQueue sub
            else
                return@PriorityQueue o2.first.compareTo(o1.first)
        }
        for (i in words){
            map[i] = map.getOrDefault(i, 0) + 1
        }
        for (i in map){
            queue.add(i.key to i.value)
            if (queue.size > k){
                queue.poll()
            }
        }
        val res = ArrayList<String>(k)
        for (i in 0 until k){
            res.add(queue.poll().first)
        }
        return res.reversed()
    }
}