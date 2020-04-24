package xiaohui;

import java.util.LinkedList;

/**
 * @author hasee
 */
public class StackGetMin {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(4);
        myStack.push(3);
        myStack.push(5);
        myStack.push(2);
        myStack.push(7);
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.getMin());
    }

    static class MyStack extends LinkedList {
        LinkedList<Integer> mainStack = new LinkedList();
        LinkedList<Integer> minStack = new LinkedList();

        int getMin() {
            return minStack.peekFirst();
        }

        @Override
        public Object pop() {
            if (mainStack.peekFirst().equals(minStack.peekFirst())) {
                minStack.pop();
            }
            return mainStack.pop();
        }

        @Override
        public void push(Object o) {
            mainStack.push((Integer) o);
            if (minStack.isEmpty()) {
                minStack.push((Integer)o);
            }
            if ((Integer) o < minStack.peekFirst()) {
                minStack.push((Integer) o);
            }
        }
    }
}
