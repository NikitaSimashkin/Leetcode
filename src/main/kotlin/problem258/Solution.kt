package problem258

class Solution {
    fun addDigits(num: Int): Int {
        return if (num != 0 && num % 9 == 0) 9 else num % 9
    }

	fun addDigits2(num: Int): Int {
		if (num < 10) return num

		var lastNum = num
		while (lastNum >= 10) {
			var current = 0
			while (lastNum > 0) {
				current += lastNum % 10
				lastNum /= 10
			}
			lastNum = current
		}

		return lastNum
	}
}