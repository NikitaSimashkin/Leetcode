package problem200

import java.util.*

class Solution {

    fun numIslands(grid: Array<CharArray>): Int {
        var result = 0
        for (i in grid.indices){
            for (j in grid[i].indices){
                if (grid[i][j] == '1') {
                    fill(grid, i, j)
                    result++
                }
            }
        }
        return result
    }

    private fun fill(grid: Array<CharArray>, i: Int, j: Int) {
        //val queue = LinkedList<Pair<Int, Int>>()
        val stack = Stack<Pair<Int, Int>>()
        stack.push(i to j)
        while(stack.isNotEmpty()){
            val cur = stack.pop()
            val (row, column) = cur
            if (row + 1 < grid.size && grid[row + 1][column] == '1')
                stack.push(row + 1 to column)
            if (column + 1 < grid[row].size && grid[row][column + 1] == '1')
                stack.push(row to column + 1)
            if (row - 1 >= 0 && grid[row - 1][column] == '1')
                stack.push(row - 1 to column)
            if (column - 1 >= 0 && grid[row][column - 1] == '1')
                stack.push(row to column - 1)
            grid[row][column] = '0'
        }
    }


    fun numIslands2(grid: Array<CharArray>): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val stack: Stack<Pair<Int, Int>> = Stack()
        val stackVisited = hashSetOf<Pair<Int, Int>>()
        val queueVisited = hashSetOf<Pair<Int, Int>>()
        queue.add(0 to 0)

        var answer = 0

        while (queue.isNotEmpty() || stack.isNotEmpty()) {
            if (stack.isNotEmpty()){
                val cur = stack.pop()
                val (row, column) = cur
                stackVisited.add(cur)

                val first = row + 1 to column
                val second = row to column + 1
                val third = row - 1 to column
                val fourth = row to column - 1

                if (first.first < grid.size && grid[first.first][first.second] == '1' && !stackVisited.contains(first))
                    stack.add(first)
                if (second.second < grid[row].size && grid[second.first][second.second] == '1' && !stackVisited.contains(second))
                    stack.add(second)
                if (third.first >= 0 && grid[third.first][third.second] == '1' && !stackVisited.contains(third))
                    stack.add(third)
                if (fourth.second >= 0 && grid[fourth.first][fourth.second] == '1' && !stackVisited.contains(fourth))
                    stack.add(fourth)
            } else {
                val cur = queue.remove()
                val (row, column) = cur
                if (grid[row][column] == '1' && !stackVisited.contains(cur)){
                    answer++
                    stack.add(cur)
                } else {
                    queueVisited.add(cur)
                }
                val first = row + 1 to column
                val second = row to column + 1

                if (first.first < grid.size && !queue.contains(first) && !queueVisited.contains(first))
                    queue.add(first)
                if (second.second < grid[row].size && !queue.contains(second) && !queueVisited.contains(second))
                    queue.add(second)
            }
        }
        return answer
    }
}