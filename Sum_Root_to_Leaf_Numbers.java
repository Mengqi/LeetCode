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
    public int sumNumbers(TreeNode root) {
        return rootNum(root, 0);
    }
    
    private int rootNum(TreeNode node, int prefix) {
        if (node == null) {
            return prefix;
        }
        
        int num = prefix * 10 + node.val;
        if ((node.left == null) && (node.right == null)) {
            return num;
        }

        int sum = 0;
        if (node.left != null) {
            sum = sum + rootNum(node.left, num);
        }
        if (node.right != null) {
            sum = sum + rootNum(node.right, num);
        }
        
        return sum;
    }
}
