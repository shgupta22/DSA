package binarytree;

import java.util.*;

public class BottomView {

    /**
     * Bottom View
     * 1) Use a HorizontalDistance Identifier
     * 2) Use HD as a Key in HashMap and put each and every Node's value in Map
     * 3) For Moving Left Decrement the current HD by 1, HD - 1;
     * 4) For Moving Right Increment the current HD by 1, HD + 1;
     * 5) Use BFS Traversal using Queue to iterate over the tree
     *
     * Time: O(N + M) N: no of Node, M: No of Edges
     * Space: O(N + N) N: for Queue, N: for HashMap
     */

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
