package binarytree;

import java.util.*;

public class BottomView {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int hd;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> bottomView(TreeNode root) {
        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        root.hd = hd;
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            hd = node.hd;
            map.put(hd, node.val);

            if (node.left != null) {
                node.left.hd = hd -1;
                queue.add(node.left);
            }

            if (node.right != null) {
                node.right.hd = hd+1;
                queue.add(node.right);
            }
        }

        map.forEach((key, value) -> result.add(value));
        return result;
    }
}
