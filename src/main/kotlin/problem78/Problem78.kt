package problem78

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()

        fun helper(i: Int, s: MutableList<Int>){
            if (i == nums.lastIndex) return

            for (j in i+1 until nums.size){
                val copy = ArrayList(s)
                copy.add(nums[j])
                answer.add(copy)
                helper(j, copy)
            }
        }

        answer.add(emptyList())
        helper(-1, mutableListOf<Int>())
        return answer
    }
}