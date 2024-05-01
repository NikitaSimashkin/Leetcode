package problem122

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        for (i in 1 until prices.size){
            if (prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1]
            }
        }
        return profit
    }

    fun maxProfit2(prices: IntArray): Int {
        var i = 0
        var profit = 0
        var buy = 0
        while (i < prices.size){
            while (i + 1 < prices.size && prices[i + 1] < prices[i]){
                i++
            }
            buy = prices[i]

            while (i + 1 < prices.size && prices[i + 1] > prices[i]){
                i++
            }
            profit+= prices[i] - buy
            i++
        }
        return profit
    }
}