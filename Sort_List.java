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
    /**
     * MergeSort
     * 1. MergeSort can sort in O(n log n) time
     * 2. Merge singly-linked list only require constant space: (a new header to store the merged list)
     */
    public ListNode sortList(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode midNode = getMidNode(head);
        ListNode leftListHead = head;
        ListNode rightListHead = midNode.next;
        midNode.next = null;

        ListNode leftList = sortList(leftListHead);
        ListNode rightList = sortList(rightListHead);
        return mergeList(leftList, rightList);
    }

    /**
     * Get the node in the first median position. For
     * example, 0->1->2->3. The mid node will be 1
     */
    private ListNode getMidNode(ListNode head) {
        int length = getLength(head);
        
        if (length == 0) {
            return null;
        }

        int mid = (length-1) / 2;
        ListNode node = head;
        int count = 0;
        while (count != mid) {
            node = node.next;
            count++;
        }

        return node;
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

    private ListNode mergeList(ListNode leftList, ListNode rightList) {
        ListNode head = null;
        
        ListNode node = null;
        ListNode curNode = null;
        while ((leftList != null) && (rightList != null)) {
            int leftVal = leftList.val;
            int rightVal = rightList.val;
            if (leftVal < rightVal) {
                node = leftList;
                leftList = leftList.next;
                node.next = null;
            } else {
                node = rightList;
                rightList = rightList.next;
                node.next = null;
            }
            
            if (head == null) {
                head = node;
                curNode = node;
            } else {
                curNode.next = node;
                curNode = node;
            }
        }
        
        if (leftList != null) {
            if (head == null) {
                head = leftList;
            } else {
                curNode.next = leftList;
            }
        } else {
            if (head == null) {
                head = rightList;
            } else {
                curNode.next = rightList;
            }
        }

        return head;
    }
}