package in.hp.java.leetcode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (!Objects.nonNull(root))
            return false;

        NewNode xNode = findNode(root, x, 0, root.val);
        NewNode yNode = findNode(root, y, 0, root.val);

        System.out.println("xNode :: " + xNode);
        System.out.println("yNode :: " + yNode);

        if (!Objects.nonNull(xNode) || !Objects.nonNull(yNode))
            return false;

        return xNode.depth == yNode.depth && xNode.parent != yNode.parent;
    }

    public NewNode findNode(TreeNode node, int x, int depth, int parent) {
        if (!Objects.nonNull(node))
            return null;
        ++depth;
        if (node.val == x) {
            return new NewNode(depth, parent);
        }
        NewNode node1 = findNode(node.left, x, depth, node.val);
        NewNode node2 = findNode(node.right, x, depth, node.val);

        return node1 != null ? node1 : node2;
    }

    class NewNode {
        int depth;
        int parent;

        NewNode(int depth, int parent) {
            this.depth = depth;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "NewNode{" +
                    "depth=" + depth +
                    ", parent=" + parent +
                    '}';
        }
    }
}

class Solution1 {
    public boolean isCousins(TreeNode root, int x, int y) {

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean siblings = false;
            boolean cousins = false;

            int nodesAtDepth = queue.size();

            for (int i = 0; i < nodesAtDepth; i++) {
                // FIFO
                TreeNode node = queue.remove();

                // Encountered the marker.
                // Siblings should be set to false as we are crossing the boundary.
                if (node == null) {
                    siblings = false;
                } else {
                    if (node.val == x || node.val == y) {
                        // Set both the siblings and cousins flag to true
                        // for a potential first sibling/cousin found.
                        if (!cousins) {
                            siblings = cousins = true;
                        } else {
                            // If the siblings flag is still true this means we are still
                            // within the siblings boundary and hence the nodes are not cousins.
                            return !siblings;
                        }
                    }

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    // Adding the null marker for the siblings
                    queue.add(null);
                }
            }
            // After the end of a level if `cousins` is set to true
            // This means we found only one node at this level
            if (cousins) return false;
        }
        return false;
    }
}