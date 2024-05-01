package problem36

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for(i in 0 until board.size){
            if (!(checkRow(i, board) &&
                        checkColumn(i, board) &&
                        checkSquare(i, board)))
                return false
        }
        return true
    }

    fun checkRow(i: Int, board: Array<CharArray>): Boolean{
        val set = hashSetOf<Char>()
        for (j in board[i]){
            if (j != '.'){
                if (j !in '1'..'9' || set.contains(j))
                    return false
                set.add(j)
            }
        }
        return true
    }

    fun checkColumn(i: Int, board: Array<CharArray>): Boolean{
        val set = hashSetOf<Char>()
        for (j in 0 until board.size){
            val cur = board[j][i]
            if (cur != '.'){
                if (cur !in '1'..'9' || set.contains(cur))
                    return false
                set.add(cur)
            }
        }
        return true
    }

    fun checkSquare(i: Int, board: Array<CharArray>): Boolean{
        val set = hashSetOf<Char>()
        for (j in 0 until board.size){
            val cur = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]
            if (cur != '.'){
                if (cur !in '1'..'9' || set.contains(cur))
                    return false
                set.add(cur)
            }
        }
        return true
    }
}