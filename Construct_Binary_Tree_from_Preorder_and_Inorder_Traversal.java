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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }
        
        int val = preorder[pStart];
        TreeNode root = new TreeNode(val);
        int iPos = iStart;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == val) {
                iPos = i;
                break;
            }
        }
        
        int leftLength = iPos - iStart;
        int rightLength = iEnd - iPos;
        TreeNode left = build(preorder, pStart+1, pStart+leftLength, inorder, iStart, iPos-1);
        TreeNode right = build(preorder, pEnd - rightLength + 1, pEnd, inorder, iPos+1, iEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}