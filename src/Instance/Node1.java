package Instance;

public class Node1 {
    public static void main(String[] args) {

    }

    public boolean isCricle(Node node) {
        Node p1=node, p2=node;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null) {
                p2 = p2.next;
            }
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
class Node{
    int val;
    Node next;
}
