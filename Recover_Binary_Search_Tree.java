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
    private TreeNode node1;
    private TreeNode node2;

    public void recoverTree(TreeNode root){
        node1 = null;
        node2 = null;
        inorder(root, null);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private TreeNode inorder(TreeNode root, TreeNode prev) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            prev = inorder(root.left, prev);
        }

        if ((prev != null) && (prev.val > root.val)) {
            if (node1 == null) {
                node1 = prev;
            }
            node2 = root;
        }

        if (root.right != null) {
            return inorder(root.right, root);
        } else {
            return root;
        }
    }
}
