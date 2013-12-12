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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int length = lists.size();

        ListNode head = null;
        ListNode prev = null;
        int emptyListCount = 0;
        while (emptyListCount != length) {
            emptyListCount = 0;
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < length; i++) {
                ListNode node = lists.get(i);
                if (node == null) {
                    emptyListCount++;
                } else {
                    if (node.val <= min) {
                        min = node.val;
                        minIndex = i;
                    }
                }
            }

            if (emptyListCount != length) {
                ListNode minNode = lists.get(minIndex);
                ListNode minNext = minNode.next;
                minNode.next = null;
                lists.set(minIndex, minNext);

                if (head == null) {
                    head = minNode;
                    prev = minNode;
                } else {
                    prev.next = minNode;
                    prev = minNode;
                }
            }
        }
        return head;
    }
}
