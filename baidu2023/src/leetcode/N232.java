package leetcode;

import java.util.LinkedList;

public class N232 {
    public static void main(String[] args) {

    }

    /**
     * 用栈实现队列
     */
    class MyQueue {
        LinkedList<Integer> stack1 = new LinkedList();
        LinkedList<Integer> stack2 = new LinkedList();

        public MyQueue() {

        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.size() > 0) {
                return stack2.pop();
            } else if (stack1.size() > 0) {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            } else {
                return 0;
            }
        }

        public int peek() {
            if (stack2.size() > 0) {
                return stack2.peek();
            } else if (stack1.size() > 0) {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            } else {
                return 0;
            }
        }

        public boolean empty() {
            return stack1.size() == 0 && stack2.size() == 0;
        }
    }
}
