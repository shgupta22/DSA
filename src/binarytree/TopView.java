package binarytree;

import java.util.*;

public class TopView {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    static class TreeNode {
        Node node;
        int hd;
        TreeNode(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int hd = 0;

        TreeNode tn = new TreeNode(root, hd);
        queue.add(tn);

        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            hd = temp.hd;

            if (!map.containsKey(hd)) map.put(hd, temp.node.data);

            if (temp.node.left != null) {
                queue.add(new TreeNode(temp.node.left, hd-1));
            }

            if (temp.node.right != null) {
                queue.add(new TreeNode(temp.node.right, hd+1));
            }
        }

        map.forEach((key, value) -> result.add(value));
        return result;

    }
}
