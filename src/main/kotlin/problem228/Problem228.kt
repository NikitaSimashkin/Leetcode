package problem228

fun main(){
    println(Solution().summaryRanges(intArrayOf(0,1,2,4,5,7)))
}

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        var i = 0
        val answer = mutableListOf<String>()
        while (i < nums.size){
            val start = nums[i]
            while(i + 1 < nums.size && nums[i + 1] == nums[i] + 1){
                i++
            }
            if (start == nums[i])
                answer.add(start.toString())
            else
                answer.add("${start}->${nums[i]}")

            i++
        }
        return answer
    }
}