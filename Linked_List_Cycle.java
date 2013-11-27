/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // edge case
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode fastNode = head;
        ListNode slowNode = head;
        while ((fastNode != null) && (slowNode != null)) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
            }
            
            if (fastNode == slowNode) {
                break;
            }
        }
        
        if (fastNode == null || slowNode == null) {
            return null;
        } else {
            slowNode = head;
            while (fastNode != slowNode) {
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }
            return slowNode;
        }
    }
}