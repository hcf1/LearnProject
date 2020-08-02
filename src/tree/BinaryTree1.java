package tree;

import java.util.LinkedList;

public class BinaryTree1 {
    static TreeNode createTree(int[] list, int index) {
        if (index >= list.length) {
            return null;
        }
        TreeNode newNode = new TreeNode(list[index]);
        newNode.left = createTree(list, index * 2 + 1);
        newNode.right = createTree(list, index * 2 + 2);
        return newNode;
    }

    static void DFS(TreeNode head) {
        if (head == null) {
            return;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.push(head);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.pop();
            System.out.println(node.value);
            if (node.right != null) {
                linkedList.push(node.right);
            }
            if (node.left != null) {
                linkedList.push(node.left);
            }
        }
    }

    static void BFS(TreeNode node) {
        if (node == null) {
            return;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(node);
        while (!linkedList.isEmpty()) {
            TreeNode node1 = linkedList.poll();
            System.out.println(node1.value);
            if (node1.left != null) {
                linkedList.offer(node1.left);
            }
            if (node1.right != null) {
                linkedList.offer(node1.right);
            }
        }
    }

    static void preTravel(TreeNode node) {
        if (node != null) {
            System.out.println(node.value);
            preTravel(node.left);
            preTravel(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode head = null;
        head = createTree(new int[]{1, 2, 3, 4, 5, 6}, 0);
        DFS(head);
        BFS(head);
    }
}

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
    }
}
