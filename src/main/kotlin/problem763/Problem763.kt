package problem763

fun main() {
    println(Solution().partitionLabels("ababcbacadefegdehijhklij"))
}

class Solution {
    fun partitionLabels(s: String): List<Int> {
        val map = IntArray(26)
        for (i in s.indices){
            map[s[i] - 'a'] = i
        }
        var start = 0
        var end = 0
        var ans = mutableListOf<Int>()
        for (i in s.indices){
            end = maxOf(end, map[s[i] - 'a'])
            if (end == i){
                ans.add(start - end + 1)
                start = end + 1
            }
        }
        return ans
    }

    fun partitionLabels2(s: String): List<Int> {
        val map = hashMapOf<Char, IntArray>()
        for (i in s.indices) {
            if (map.contains(s[i])) {
                map[s[i]]!![1] = i
            } else {
                map[s[i]] = IntArray(2) { i }
            }
        }

        val chars = map.map { it.value }.toMutableList()
        quickSort(chars, Comparator { o1: IntArray, o2: IntArray ->
            o1[0] - o2[0]
        }, 0, chars.lastIndex)
        chars.forEach { print("${it.contentToString()} ") }
        println()
        val ans = arrayListOf<Int>()
        var cur = 0
        while (cur < chars.size) {
            var start = chars[cur][0]
            var end = chars[cur][1]
            while (cur + 1 < chars.size && (chars[cur + 1][0] in start..end)) {
                end = maxOf(end, chars[cur + 1][1])
                cur++
            }
            ans.add(end - start + 1)
            cur++
        }
        return ans
    }

    fun <T> quickSort(list: MutableList<T>, c: Comparator<T>, L: Int, R: Int) {
        if (R - L <= 0) return

        var l = L
        var r = R
        val middle = list[(l + r) / 2]
        while (l <= r) {
            while (c.compare(list[l], middle) < 0)
                l++
            while (c.compare(list[r], middle) > 0)
                r--
            if (l <= r) {
                swap(list, l, r)
                l++
                r--
            }
        }
        quickSort(list, c, L, r)
        quickSort(list, c, l, R)
    }

    fun <T> swap(list: MutableList<T>, one: Int, two: Int) {
        val temp = list[two]
        list[two] = list[one]
        list[one] = temp
    }
}