/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode currNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (currNode.val == nextNode.val) {
                currNode.next = nextNode.next;
                if (currNode != null) {
                    nextNode = currNode.next;
                } else {
                    nextNode = null;
                }
            } else {
                currNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        return head;
    }
}