/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        root = getTree(root);
    }

    private TreeNode getTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode last = root;
        TreeNode leftLast = getTree(root.left);
        TreeNode rightLast = getTree(root.right);
        if (root.left != null) {
            last = leftLast;
            leftLast.right = root.right;
        }
        if (root.right != null) {
            last = rightLast;
        }

        if (root.left != null) {
            root.right = root.left;
        }
        root.left = null;

        return last;
    }
}
