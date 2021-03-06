import java.util.ArrayDeque;

/**
 * 用两个栈实现一个队列
 * 思路：offer进去的元素先进入一个栈，当要poll的时候，如果另一个栈有元素，则直接pop出去。如果是空的，就先把有元素的这个栈里的全部元素
 * 移入另一个栈，然后再取出
 *
 * @author hasee
 */
public class BuildQueueByTwoStackes {
    private ArrayDeque<Integer> stack1 = new ArrayDeque();
    private ArrayDeque<Integer> stack2 = new ArrayDeque();

    void offer(Integer value) {
        stack1.push(value);
    }

    Integer poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return null;
        } else {
            return stack2.pop();
        }
    }
}
/**
 * 正式批
 */
class BuildQueueByTwoStackes1{
    ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
    ArrayDeque<Integer> arrayDeque2 = new ArrayDeque<>();

    void offer(int value) {
        arrayDeque1.push(value);
    }

    Integer poll() {
        if (!arrayDeque2.isEmpty()) {
            return arrayDeque2.pop();
        } else {
            while (!arrayDeque1.isEmpty()) {
                arrayDeque2.push(arrayDeque1.pop());
            }
            if (!arrayDeque2.isEmpty()) {
                return arrayDeque2.pop();
            } else {
                return null;
            }
        }
    }
}

/**
 * 使用两个队列实现一个栈
 * 思路：每次留出一个空的队列，pop时先将一个队列中的n-1个元素移入一个空队列，将另一个队列中剩下的最后一个元素弹出
 * 时间复杂度O(n**2)，即每pop出一个元素都要移动n-1个元素
 * */
class BuildStackByTwoQueues {
    private ArrayDeque<Integer> queue1 = new ArrayDeque<>();
    private ArrayDeque<Integer> queue2 = new ArrayDeque<>();

    void push(Integer value) {
        if (!queue1.isEmpty()) {
            queue1.offer(value);
        } else {
            queue2.offer(value);
        }
    }

    Integer pop() {
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }
}
/**
 * 正式批
 */
class BuildStackByTwoQueues1{
    ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
    ArrayDeque<Integer> arrayDeque2 = new ArrayDeque<>();

    void push(int value) {
        arrayDeque1.offer(value);
    }

    Integer pop() {
        if (arrayDeque2.isEmpty()) {//1往2移
            while (arrayDeque1.size()>1) {
                arrayDeque2.offer(arrayDeque1.poll());
            }
            if (arrayDeque1.size() == 0) {
                return null;
            }
            return arrayDeque1.poll();
        } else {
            while (arrayDeque2.size()>1) {
                arrayDeque1.offer(arrayDeque2.poll());
            }
            if (arrayDeque2.size() == 0) {
                return null;
            }
            return arrayDeque2.poll();
        }
    }
}