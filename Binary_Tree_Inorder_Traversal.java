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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> treeList = new ArrayList<Integer>();
        
        inorder(root, treeList);
        
        return treeList;
    }
    
    private void inorder(TreeNode root, ArrayList<Integer> treeList) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, treeList);
        treeList.add(root.val);
        inorder(root.right, treeList);
    }
}

