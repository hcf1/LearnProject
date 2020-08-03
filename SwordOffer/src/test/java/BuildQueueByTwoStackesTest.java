

class BuildQueueByTwoStackesTest {
    public static void main(String[] args) {
        testCreateQueue();
        System.out.println("以下是stack的结果：");
        testCreateStack();
    }

    private static void testCreateStack() {
        BuildStackByTwoQueues1 stack = new BuildStackByTwoQueues1();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static void testCreateQueue() {
        BuildQueueByTwoStackes1 queue = new BuildQueueByTwoStackes1();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.poll());
    }
}