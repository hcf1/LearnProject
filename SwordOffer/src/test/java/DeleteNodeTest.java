import java.util.Date;

class DeleteNodeTest {
    public static void main(String[] args) {
        DeleteNode.Node1 head = new DeleteNode.Node1(0);
        DeleteNode.Node1 hp = head;
        head.next = new DeleteNode.Node1(1);
        head = head.next;
        head.next = new DeleteNode.Node1(2);
        head = head.next;
        //p指向2
//        DeleteNode.Node1 p = head;
        head.next = new DeleteNode.Node1(3);
        head = head.next;
        //p指向最后
        DeleteNode.Node1 p = head;
        printResult1(hp, p);
        System.out.println("测试第二题");
        buildTest2();

    }

    private static void printResult1(DeleteNode.Node1 hp, DeleteNode.Node1 toBeRemoved) {
        DeleteNode.Node1 head;//输出创建后的链表
        head = hp.next;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
        System.out.printf("删除%d号节点\n", toBeRemoved.value);
        DeleteNode.Problem1 problem1 = new DeleteNode.Problem1();
        problem1.deleteNode(hp, toBeRemoved);
        //输出删除后的链表
        head = hp.next;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    static void buildTest2() {
        DeleteNode.Node1 head = new DeleteNode.Node1(0);
        DeleteNode.Node1 p = head;
        head.next = new DeleteNode.Node1(1);
        head = head.next;
        head.next = new DeleteNode.Node1(1);
        head = head.next;
        head.next = new DeleteNode.Node1(1);
        head = head.next;
        head.next = new DeleteNode.Node1(1);
        head = head.next;
        head.next = new DeleteNode.Node1(1);
        head = p.next;
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
        head = p;
        DeleteNode.Problem2 problem2 = new DeleteNode.Problem2();
        problem2.deleteRepeated(head);
        head = p.next;
        System.out.println("删除重复节点后");
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}