package problem69

class Solution {
	fun mySqrt(x: Int): Int {
		if (x == 0 || x == 1) return x

		var l = 1L
		var r: Long = x.toLong()
		while (l <= r) {
			val middle: Long = (l + r) / 2
			if (middle * middle > x) {
				r = middle - 1
			} else if (middle * middle < x) {
				l = middle + 1
			} else {
				return middle.toInt()
			}
		}

		return r.toInt()
	}
}