package problem5

class Solution {
    fun longestPalindrome(s: String): String {
        var max = s[0].toString()
        for (i in 0..s.lastIndex){
            var l = i - 1
            var r = i + 1
            while (l >= 0 && r < s.length && s[l] == s[r]){
                l--
                r++
            }
            max = if (max.length < r - l - 1) s.substring(l + 1, r) else max

            if (i + 1 < s.length && s[i] == s[i + 1]){
                var l = i - 1
                var r = i + 2
                while (l >= 0 && r < s.length && s[l] == s[r]){
                    l--
                    r++
                }
                max = if (max.length < r - l - 1) s.substring(l + 1, r) else max
            }
        }
        return max
    }
}