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
        if ((l1 == null) && (l2 == null)) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode prev = null;
        int digit;
        int carry = 0;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while ((node1 != null) && (node2 != null)) {
            digit = node1.val + node2.val + carry;
            if (digit >= 10) {
                digit = digit - 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode node = new ListNode(digit);
            node.next = null;
            if (head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null) {
            digit = node1.val + carry;
            if (digit >= 10) {
                digit = digit - 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode node = new ListNode(digit);
            node.next = null;
            if (head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }

            node1 = node1.next;
        }

        while (node2 != null) {
            digit = node2.val + carry;
            if (digit >= 10) {
                digit = digit - 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode node = new ListNode(digit);
            node.next = null;
            if (head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }

            node2 = node2.next;
        }

        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = null;
            if (head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }
        }

        return head;
    }
}
