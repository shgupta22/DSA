package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void preorder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val);
        if (root.left != null)
            preorder(root.left);

        if (root.right != null)
            preorder(root.right);
    }

    public static void preorderItr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return;
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void inorderItr(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;

        if (root.left != null)
            inorder(root.left);
        System.out.print(root.val);
        if (root.right != null)
            inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) postorder(root.left);
        if (root.right != null) postorder(root.right);
        System.out.print(root.val);
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = f;
        c.left = e;
        c.right = g;

        preorder(a);
        System.out.println();
        preorderItr(a);
        System.out.println();
        inorder(a);
        System.out.println();
        inorderItr(a);
        System.out.println();
        postorder(a);
        System.out.println();
        levelOrder(a);
    }
}
