package swordoffer;

import other.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 树的子结构
 */
public class N26 {
    LinkedList<TreeNode> result = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode A = new TreeNode(-2);
        A.left = new TreeNode(1);
        A.right = new TreeNode(-1);

        TreeNode B = new TreeNode(-2);
        B.left = new TreeNode(1);
        B.right = new TreeNode(1);
        System.out.println(new N26().isSubStructure(A, B));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A != null && B == null) {
            return false;
        }
        findBHead(A, B);
        while (!result.isEmpty()) {
            List<Integer> listA = new LinkedList();
            List<Integer> listB = new LinkedList();
            traversal(result.pop(), listA);
            traversal(B, listB);
            int compare = 0;
            if (listA.size() == listB.size()) {
                for (int i = 0; i < listA.size(); i++) {
                    if (Objects.equals(listA.get(i), listB.get(i))) {
                        compare = i;
                    }else {
                        break;
                    }
                }
            }
            if (compare == listA.size() - 1) {
                return true;
            }
        }
        return false;
    }

    void findBHead(TreeNode A, TreeNode B) {
        if (A == null) {
            return;
        }
        if (A.val == B.val) {
            result.add(A);
        }
        findBHead(A.left, B);
        findBHead(A.right, B);
    }

    void traversal(TreeNode root, List result) {
        if (root == null) {
            result.add(null);
            return;
        }
        result.add(root.val);
        traversal(root.left, result);
        traversal(root.right, result);
    }
}
