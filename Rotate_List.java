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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int length = getLength(head);

        n = n % length;
        if (n == 0) {
            return head;
        }

        int currPos = length - n;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        int pos = 1;
        while (pos < currPos) {
            currNode = nextNode;
            nextNode = nextNode.next;
            pos++;
        }

        ListNode endNode = nextNode;
        while (endNode.next != null) {
            endNode = endNode.next;
        }

        currNode.next = null;
        endNode.next = head;
        head = nextNode;

        return head;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
