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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode build(int []inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd) {
            return null;
        }
        
        int val = postorder[pEnd];
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
        TreeNode left = build(inorder, iStart, iPos-1, postorder, pStart, pStart+leftLength-1);
        TreeNode right = build(inorder, iPos+1, iEnd, postorder, pEnd-rightLength, pEnd-1);
        root.left = left;
        root.right = right;
        return root;
    }
}