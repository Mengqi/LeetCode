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
        connectNode(root, null);
    }

    private void connectNode(TreeLinkNode root, TreeLinkNode next) {
        if (root == null) {
            return;
        }

        root.next = next;

        TreeLinkNode nextChild = null;  // child level next node
        TreeLinkNode node = next;
        while (node != null) {
            if (node.left != null) {
                nextChild = node.left;
                break;
            }
            if (node.right != null) {
                nextChild = node.right;
                break;
            }
            node = node.next;
        }

        if (root.right != null) {
            connectNode(root.right, nextChild);
            nextChild = root.right;
        }
        if (root.left != null) {
            connectNode(root.left, nextChild);
        }
    }
}
