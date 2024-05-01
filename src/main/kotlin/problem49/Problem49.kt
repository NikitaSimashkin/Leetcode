package problem49

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<String, MutableList<String>>()
        for (i in strs){
            val key = i.toList().sorted().toString()
            if (!map.contains(key))
                map[key] = mutableListOf()
            map[key]!!.add(i)
        }
        return map.values.toList()
    }
}