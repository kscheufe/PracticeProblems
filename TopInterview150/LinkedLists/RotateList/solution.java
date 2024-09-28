/*
Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1] 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int numNodes = 0;
        ListNode iterator = head;
        if (head == null || head.next == null) return head;
        while (iterator != null)
        {
            numNodes++;
            iterator = iterator.next;
        }
        k = k % numNodes;
        if (k == 0) return head;
        iterator = head;
        //move until you find node numNodes-k
        k = numNodes - k;
        while (k > 1)//stop one iteration before the target head
        {
            k--;
            iterator = iterator.next;
        }
        ListNode temp = iterator.next;//get targetHead as temp
        iterator.next = null;//break the connection between the targetHead and old prefix
        iterator = temp;//move the iterator to the new head
        //advance until the end of existing LL
        while (iterator.next != null) iterator = iterator.next;
        //set tail of old LL's next as the head of old LL
        iterator.next = head;
        return temp;//return the new head
    }
}