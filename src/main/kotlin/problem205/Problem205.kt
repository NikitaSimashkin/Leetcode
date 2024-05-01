package problem205

class Solution {
	fun isIsomorphic(s: String, t: String): Boolean {
		if (s.length != t.length) return false

		val matches = HashMap<Char, Char>()

		for (i in s.indices) {
			if (matches.contains(s[i])) {
				if (t[i] != matches[s[i]]) {
					return false
				}
			} else {
				if (matches.values.contains(t[i])) return false
				matches[s[i]] = t[i]
			}
		}

		return true
	}
}