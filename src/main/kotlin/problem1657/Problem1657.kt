package problem1657

class Solution {
	fun closeStrings(word1: String, word2: String): Boolean {
		if (word1.length != word2.length) return false

		val m1 = HashMap<Char, Int>()
		val m2 = HashMap<Char, Int>()

		for (i in word1.indices) {
			m1[word1[i]] = m1.getOrDefault(word1[i], 0) + 1
			m2[word2[i]] = m2.getOrDefault(word2[i], 0) + 1
		}

		return m1.values.sorted() == m2.values.sorted() && m1.keys == m2.keys
	}
}