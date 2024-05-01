package problem322

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val array = IntArray(amount + 1){-1}
        array[0] = 0
        for (j in 1..amount){
            var cur = Int.MAX_VALUE
            for (i in coins){
                if (j - i >= 0 && array[j - i] != -1)
                    cur = minOf(cur, 1 + array[j-i])
            }
            array[j] = if (cur != Int.MAX_VALUE) cur else -1
        }

        return array[amount]
    }

    fun coinChange2(coins: IntArray, amount: Int): Int {
        val map = hashMapOf<Int, Int>()

        fun count(a: Int): Int{
            if (a == 0) return 0
            if (a < 0) return -1
            if (map.contains(a)) return map[a]!!

            var cur = Int.MAX_VALUE
            for (i in coins){
                val c = count(a - i)
                if (c != -1)
                    cur = minOf(cur, 1 + c)
            }
            map[a] = if (cur == Int.MAX_VALUE) -1 else cur
            return map[a]!!
        }

        return count(amount)
    }
}