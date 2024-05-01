package problem139

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return count(s, wordDict, hashMapOf<String, Boolean>())
    }

    fun count(s: String, wordDict: List<String>, map: HashMap<String, Boolean>): Boolean{
        if (map.contains(s)) return map[s]!!
        val cur = StringBuilder()
        for (i in s.indices){
            cur.append(s[i])
            if (wordDict.contains(cur.toString()) && (i == s.lastIndex || count(s.substring(i + 1), wordDict, map))){
                map[s] = true
                return true
            }
        }
        map[s] = false
        return map[s]!!
    }
}