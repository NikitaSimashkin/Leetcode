package problem58

class Solution {
    fun lengthOfLastWord(s: String): Int {
        var length = 0
        var i = 0
        while (i < s.length){
            var curLength = 0
            while(i < s.length && s[i] == ' ')
                i++
            while(i < s.length && s[i] != ' '){
                curLength++
                i++
            }
            if (curLength != 0)
                length = curLength
        }
        return length
    }
}