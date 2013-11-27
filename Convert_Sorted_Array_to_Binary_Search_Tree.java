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
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }
        
        return makeBST(num, 0, num.length - 1);    
    }
    
    private TreeNode makeBST(int[] num, int start, int end) {
        if ((num == null) || (num.length == 0) || (start > end)) {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode left = makeBST(num, start, mid-1);
        TreeNode right = makeBST(num, mid+1, end);
        
        TreeNode node = new TreeNode(num[mid]);
        node.left = left;
        node.right = right;
        return node;
    }
}
