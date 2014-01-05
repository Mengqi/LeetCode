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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode prev = null;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + carry;
            int digit = num % 10;
            carry = (num - digit) / 10;
            
            ListNode node = new ListNode(digit);

            if (head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }

            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int num = l1.val + carry;
            int digit = num % 10;
            carry = (num - digit) / 10;

            ListNode node = new ListNode(digit);

            if (head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }

            l1 = l1.next;
        }
        
        while (l2 != null) {
            int num = l2.val + carry;
            int digit = num % 10;
            carry = (num - digit) / 10;

            ListNode node = new ListNode(digit);

            if (head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }

            l2 = l2.next;
        }
        
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            prev.next = node;
        }
        
        return head;
    }
}
