package problem20

import java.util.*

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (i in s){
            if (i in "({[")
                when(i){
                    '(' -> stack.add(')')
                    '[' -> stack.add(']')
                    '{' -> stack.add('}')
                }
            else {
                if (stack.isEmpty())
                    return false
                else {
                    val ch = stack.pop()
                    if (i != ch)
                        return false
                }
            }
        }
        return stack.isEmpty()
    }
}