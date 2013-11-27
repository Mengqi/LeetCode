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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int height = getHeight(root);
        return (height != -1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if ((leftHeight == -1) || (rightHeight == -1)) {
            return -1;
        }
        if ((leftHeight > rightHeight + 1) || (rightHeight > leftHeight + 1)) {
            return -1;
        }
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }
}