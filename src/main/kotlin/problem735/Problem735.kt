package problem735

import java.util.Stack
import kotlin.math.abs

class Solution {

	fun asteroidCollision(asteroids: IntArray): IntArray {
		val result = Stack<Int>()
		for (current in asteroids) {
			if (current > 0 || result.isEmpty()) {
				result.add(current)
			} else {
				while(result.isNotEmpty()) {
					val last = result.peek()
					if (last < 0) {
						result.add(current)
						break
					} else if (last + current == 0) {
						result.pop()
						break
					} else if (last + current > 0) {
						break
					} else {
						result.pop()
						if (result.isEmpty()) {
							result.add(current)
							break
						}
					}
				}
			}
		}

		return result.toIntArray()
	}

    fun asteroidCollision2(asteroids: IntArray): IntArray {
        val result = asteroids.toMutableList()
        var currentIndex = 0
        while (currentIndex < result.size - 1 && currentIndex >= 0) {
            val next = currentIndex + 1
            if (result[currentIndex] * result[next] > 0) {
                currentIndex++
                continue
            } else {
                if (result[currentIndex] < 0 && result[next] > 0) {
                    currentIndex++
                } else if (abs(result[currentIndex]) > abs(result[next])) {
                    result.removeAt(next)
                } else if (abs(result[currentIndex]) < abs(result[next])) {
                    result.removeAt(currentIndex)
                    currentIndex = (currentIndex - 1).coerceAtLeast(0)
                } else {
                    result.removeAt(next)
                    result.removeAt(currentIndex)
                    currentIndex = (currentIndex - 1).coerceAtLeast(0)
                }
            }
        }
        return result.toIntArray()
    }
}