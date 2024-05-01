package problem48

class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        for (i in 0 until (matrix.size/2)){
            for (j in i until matrix[i].lastIndex - i){
                val one = matrix[i][j]
                matrix[i][j] = matrix[matrix.lastIndex - j][i]
                matrix[matrix.lastIndex - j][i] = matrix[matrix.lastIndex - i][matrix.lastIndex - j]
                matrix[matrix.lastIndex - i][matrix.lastIndex - j] = matrix[j][matrix.lastIndex - i]
                matrix[j][matrix.lastIndex - i] = one
            }
        }
    }
}