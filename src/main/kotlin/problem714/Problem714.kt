package problem714

class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var current = 0
        var min = 0
        var secondMin = 0
        var max = 0
        var result = 0
        var flag = true
        while (current < prices.size){
            if (flag){
                while (current + 1 < prices.size && prices[current] >= prices[current + 1]){
                    current++
                }

                min = current
                current++
            }

            while (current + 1 < prices.size && prices[current] <= prices[current + 1]){
                current++
            }

            max = current
            current++
            if (current >= prices.size)
                break

            while (current + 1 < prices.size && prices[current] > prices[current + 1]){
                current++
            }

            secondMin = current
            if (current >= prices.size)
                break

            if (current != prices.lastIndex && prices[max] - prices[secondMin] >= fee && prices[max] - prices[min] >= fee ){
                result += prices[max] - prices[min] - fee
                println("${prices[max]} ${prices[min]}")
                flag = true
                current = max + 1
            } else {
                if (prices[secondMin] <= prices[min]){
                    min = secondMin
                }
                flag = false
                current++
            }

        }
        if (max < prices.size && min < prices.size)
            result += prices[max] - prices[min] - fee
        return if (result < 0) return 0 else result
    }
}