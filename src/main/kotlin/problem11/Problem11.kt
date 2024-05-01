package problem11

class Solution {
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.lastIndex
        var max = 0
        while (l < r){
            max = maxOf(max, minOf(height[l], height[r]) * (r - l))
            if (height[l] < height[r])
                l++
            else
                r--
        }
        return max
    }
}