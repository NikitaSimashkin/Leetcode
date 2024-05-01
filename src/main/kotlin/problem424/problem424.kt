package problem424

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var answer = 0
        val map = hashMapOf<Char, Int>()
        var max = 0
        var start = 0
        for (j in 0 until s.length){
            map[s[j]] = map.getOrDefault(s[j], 0) + 1
            if (map[s[j]]!! > max)
                max = map[s[j]]!!

            if (j - start + 1 - max <= k)
                answer = maxOf(answer, j - start + 1)
            else {
                map[s[start]] = map[s[start]]!! - 1
                max--
                start++
            }
        }
        return answer
    }
}