package binarytree;

import java.util.*;

public class ZigZagTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public static List<List<Integer>> zigZag(TreeNode root) {
        if (root == null) return List.of();

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        int l =1;
        while(!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> levelRes = new ArrayList<>();
            TreeNode temp;
            for (int i=0; i <n;i++) {
                if (l%2 == 0) {
                    temp = deque.pollLast();
                } else {
                    temp = deque.pollFirst();
                }
                levelRes.add(temp.val);
                if (l%2 == 0) {
                    if (temp.right != null) {
                        deque.addFirst(temp.right);
                    }
                    if (temp.left != null) {
                        deque.addFirst(temp.left);
                    }
                } else {
                    if (temp.left != null) {
                        deque.addLast(temp.left);
                    }
                    if (temp.right != null) {
                        deque.addLast(temp.right);
                    }
                }
            }
            l++;
            result.add(levelRes);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        System.out.println(zigZag(a));
    }
}
