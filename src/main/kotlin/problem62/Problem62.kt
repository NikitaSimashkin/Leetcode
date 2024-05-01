package problem62

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val arr = Array<IntArray>(m){IntArray(n)}
        arr[0][0] = 1
        for (i in arr.indices){
            for (j in arr[i].indices){
                if (i - 1 >= 0)
                    arr[i][j] = arr[i][j] + arr[i - 1][j]
                if (j - 1 >= 0)
                    arr[i][j] = arr[i][j] + arr[i][j - 1]
            }
        }
        return arr[m - 1][n - 1]
    }
}