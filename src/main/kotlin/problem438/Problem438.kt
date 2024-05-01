package problem438

class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length) return listOf<Int>()
        val answer = mutableListOf<Int>()
        val sMap = hashMapOf<Char, Int>()
        val pMap = hashMapOf<Char, Int>()
        for (i in p.indices){
            pMap[p[i]] = pMap.getOrDefault(p[i], 0) + 1
            sMap[s[i]] = sMap.getOrDefault(s[i], 0) + 1
        }
        if (pMap == sMap)
            answer.add(0)

        var lastIndex = 0
        for (i in p.length until s.length){
            sMap[s[lastIndex]] = sMap.getOrDefault(s[lastIndex], 0) - 1
            sMap[s[i]] = sMap.getOrDefault(s[i], 0) + 1
            if (sMap.getOrDefault(s[lastIndex], 0) == 0)
                sMap.remove(s[lastIndex])
            lastIndex++
            if (sMap == pMap)
                answer.add(lastIndex)
        }
        return answer
    }
}