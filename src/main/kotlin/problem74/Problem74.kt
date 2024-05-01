package problem74

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var l = 0
        var r = matrix.size
        var array: IntArray? = null
        while (l <= r){
            val middle = (l + r)/2
            val valueLeft = matrix[middle][0]
            val valueRight = matrix[middle][matrix[middle].lastIndex]
            if (target in valueLeft..valueRight){
                array = matrix[middle]
                break
            } else if (target > valueRight){
                l = middle + 1
            } else {
                r = middle - 1
            }
        }
        if (array == null) return false

        l = 0
        r = array.lastIndex
        while (l <= r){
            val middle = (l + r)/2
            if (target == array[middle]){
                return true
            } else if (target > array[middle]){
                l = middle + 1
            } else {
                r = middle - 1
            }
        }
        return false
    }
}