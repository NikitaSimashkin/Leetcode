package problem38

class Solution {
    fun countAndSay(n: Int): String {
        if (n == 1) return "1"

        val str = countAndSay(n - 1)
        var ans = ""
        var i = 0
        while (i < str.length){
            var counter = 1
            while (i + 1 < str.length && str[i] == str[i + 1]){
                counter++
                i++
            }
            ans += "$counter${str[i]}"
            i++
        }
        return ans
    }
}