import java.util.Scanner;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
        ListNode head1 = addTwoNumbers2.new ListNode(0);
        ListNode head2 = addTwoNumbers2.new ListNode(0);
        ListNode p = head1;
        ListNode q = head2;
        Solution solution = addTwoNumbers2.new Solution();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < 3) {
            p.next = addTwoNumbers2.new ListNode(scanner.nextInt());
            p = p.next;
            i++;
        }
        i = 0;
        System.out.println("第二行");
        while (i < 3) {
            q.next = addTwoNumbers2.new ListNode(scanner.nextInt());
            q = q.next;
            i++;
        }
        ListNode listNode = solution.addTwoNumbers(head1, head2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = l1.next;
            l2 = l2.next;
            AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
            double a = 0, b = 0;
            int k = 0, r = 0;
            ListNode head3 = addTwoNumbers2.new ListNode(0);
            do {//获取链表1的值
                a += Math.pow(10, k) * l1.val;
                l1 = l1.next;
                k++;
            } while (l1 != null);
            do {//获取链表2的值
                b += Math.pow(10, r) * l2.val;
                l2 = l2.next;
                r++;
            }
            while (l2 != null);
            int sum = (int) (a + b);
            k=Math.max(k,r);//取两个数的最大位数
            int n = (int) Math.pow(10, k);
            if (sum / n == 0) {//两数和没有进位
                int[] pos = new int[k];
                int p = (k - 1), s = 0, num = sum;
                while (p >= 0 && s < k) {//先将数按从低到高为存入数组
                    pos[s] = (int) (num / Math.pow(10, p));
                    num -= (int) (pos[s] * Math.pow(10, p));
                    s++;
                    p--;
                }
                int u = k - 1;
//                head3.val = pos[u];
//                u--;
                ListNode p3 = head3;
                while (u >= 0) {//从数组取出存入链表
                    p3.next = addTwoNumbers2.new ListNode(pos[u]);
                    p3 = p3.next;
                    u--;
                }
            }
            return head3;
        }
        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                int sum = x + y + carry;
                carry = sum / 10;//判断是否有进位
                sum = sum % 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
            return pre.next;
        }
    }
}
