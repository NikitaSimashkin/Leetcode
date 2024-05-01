package problem121

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var profit = 0
        for (i in prices.indices){
            if (prices[i] < minPrice){
                minPrice = prices[i]
            } else {
                val cur = prices[i] - minPrice
                if (cur > profit){
                    profit = cur
                }
            }
        }
        return profit
    }
}