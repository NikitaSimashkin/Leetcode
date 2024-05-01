package problem242

class Solution {
    fun isAnagram1(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val tMap = hashMapOf<Char, Int>()
        val sMap = hashMapOf<Char, Int>()

        for (i in s.indices){
            tMap[t[i]] = tMap.getOrDefault(t[i], 0) + 1
            sMap[s[i]] = sMap.getOrDefault(s[i], 0) + 1
        }

        return tMap == sMap
    }

    fun isAnagram2(s: String, t: String): Boolean {
        return s.toCharArray().sorted().toString() == t.toCharArray().sorted().toString()
    }
}