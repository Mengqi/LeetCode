/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connectNode(root, null);
    }
    
    public TreeLinkNode connectNode(TreeLinkNode root, TreeLinkNode prev) {
        if (root == null) {
            return null;
        }
        
        TreeLinkNode prevChild = null;
        if (prev != null) {
            prev.next = root;
            prevChild = prev.right;
        }

        connectNode(root.left, prevChild);
        connectNode(root.right, root.left);
        return root.right;
    }
}