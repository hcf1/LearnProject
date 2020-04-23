package tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author hcf
 */
@SuppressWarnings("ALL")
public class BinaryTree {
    private static TreeNodeTwo root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        root = binaryTree.creatCompleteBinaryTree(root, new int[]{1, 2, 3, 4, 5}, 0);
        binaryTree.postOrderTravers2(root);
    }

    TreeNodeTwo creatCompleteBinaryTree(TreeNodeTwo node, int[] arr, int index) {
        if (index >= arr.length) {
            return node;
        }
        TreeNodeTwo newNode = new TreeNodeTwo(arr[index]);
        node = newNode;
        node.left = creatCompleteBinaryTree(node.left, arr, index * 2 + 1);
        node.right = creatCompleteBinaryTree(node.right, arr, index * 2 + 2);
        return node;
    }

    void BFS(TreeNodeTwo root) {
        LinkedList<TreeNodeTwo> list = new LinkedList();
        list.offer(root);
        while (!list.isEmpty()) {
            TreeNodeTwo treeNode = list.poll();
            System.out.println(treeNode.value);
            if (treeNode.left != null) {
                list.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                list.offer(treeNode.right);
            }

        }
    }

    void DFS(TreeNodeTwo root) {
        LinkedList<TreeNodeTwo> list = new LinkedList<>();
        list.push(root);
        while (!list.isEmpty()) {
            TreeNodeTwo treeNode = list.pop();
            System.out.println(treeNode.value);
            if (treeNode.right != null) {
                list.push(treeNode.right);
            }
            if (treeNode.left != null) {
                list.push(treeNode.left);
            }
        }
    }

    void preOrderTravers(TreeNodeTwo node) {
        if (node != null) {
            System.out.println(node.value);
            preOrderTravers(node.left);
            preOrderTravers(node.right);
        }
    }

    void inOrderTravers(TreeNodeTwo node) {
        if (node != null) {
            inOrderTravers(node.left);
            System.out.println(node.value);
            inOrderTravers(node.right);
        }
    }

    void postOrderTravers(TreeNodeTwo node) {
        if (node != null) {
            postOrderTravers(node.left);
            postOrderTravers(node.right);
            System.out.println(node.value);
        }
    }

    void preOrderTravers2(TreeNodeTwo root) {
        LinkedList<TreeNodeTwo> list = new LinkedList();
        TreeNodeTwo pNode = root;
        while (!list.isEmpty() || pNode != null) {
            if (pNode != null) {
                System.out.println(pNode.value);
                list.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNodeTwo node = list.pop();
                pNode = node.right;
            }
        }
    }

    void inOrderTravers2(TreeNodeTwo root) {
        LinkedList<TreeNodeTwo> list = new LinkedList();
        TreeNodeTwo pNode = root;
        while (!list.isEmpty() || pNode != null) {
            if (pNode != null) {
                list.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNodeTwo node = list.pop();
                System.out.println(node.value);
                pNode = node.right;
            }
        }
    }

    void postOrderTravers2(TreeNodeTwo root) {
        Stack<TreeNodeTwo> src = new Stack<TreeNodeTwo>();
        Stack<TreeNodeTwo> res = new Stack<TreeNodeTwo>();
        src.push(root);
        while (!src.isEmpty()) {
            TreeNodeTwo p = src.pop();
            res.push(p);
            //和先序遍历左右子树入栈的顺序相反
            if (p.left != null) {
                src.push(p.left);
            }
            if (p.right != null) {
                src.push(p.right);
            }
        }
        //输出最终后序遍历的结果
        while (!res.isEmpty()) {
            System.out.print(res.pop().value + " ");
        }

    }
}

class TreeNodeTwo {
    int value;
    TreeNodeTwo left;
    TreeNodeTwo right;

    TreeNodeTwo(int value) {
        this.value = value;
    }
}
