package problem232

import java.util.*

class MyQueue() {
    private val stack1: Stack<Int> = Stack()
    private val stack2: Stack<Int> = Stack()

    fun push(x: Int) {
        stack1.push(x)
    }

    fun pop(): Int {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop())
            }
        }
        return stack2.pop()
    }

    fun peek(): Int {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop())
            }
        }
        return stack2.peek()
    }

    fun empty() = stack1.isEmpty() && stack2.isEmpty()

}