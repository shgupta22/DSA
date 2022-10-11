package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> leftView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            for (int i=0; i < n; i++) {
                TreeNode node = queue.poll();
                if (i == n-1) {
                    result.add(node.val);
                }

                if (node.right != null) queue.add(root.right);
                if (node.left != null) queue.add(root.left);
            }
        }
        return result;
    }
}
