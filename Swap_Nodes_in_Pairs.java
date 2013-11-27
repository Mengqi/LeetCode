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
    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        
        ListNode prev = head;
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            if (prev == head) {
                head = next;
                curr.next = next.next;
                next.next = curr;
            } else {
                prev.next = next;
                curr.next = next.next;
                next.next = curr;
            }
            // already swapped, next->curr
            prev = curr;
            curr = curr.next;
            if (curr != null) {
                next = curr.next;
            } else {
                next = null;
            }            
        }
        return head;
    }
}

