package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {

    /**
     * Left View : Use Queue Level Order Traversal
     * For Level Order put the right Node first and then the left Node
     * 1) For Each level get Size and iterate over the size to Poll from Queue
     * 2) If ( I == LevelSize (N)) result.add(node.Value);
     * 3) if (node.right != null) queue.add(node.right)
     * 4) if (node.left != null) queue.add(node.left)
     *
     * Similar Approach will be used for Right View where place the Left Node first and then Right Node
     */

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
