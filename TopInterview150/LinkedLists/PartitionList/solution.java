/*
Given the head of a linked list and a value x, partition it such that all
nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of 
the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
 
Constraints:
The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
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
    public ListNode partition(ListNode head, int x) {
        ListNode gtHead = null;
        ListNode ltHead = null;
        ListNode gtTail = null;//these two only need init for JVM
        ListNode ltTail = null;
        ListNode iterator = head;
        if (head == null || head.next == null)
        {
            return head;
        }
        while (iterator != null)
        {
            if (iterator.val < x)
            {
                if (ltHead == null)
                {
                    ltHead = iterator;
                    ltTail = iterator;
                }
                else
                {
                    ltTail.next = iterator;
                    ltTail = iterator;
                }
            }
            else
            {
                if (gtHead == null)
                {
                    gtHead = iterator;
                    gtTail = iterator;
                }
                else
                {
                    gtTail.next = iterator;
                    gtTail = iterator;
                }
            }
            iterator = iterator.next;
        }
        if (ltHead == null || gtHead == null)
        {
            return head;
        }
        ltTail.next = gtHead; 
        gtTail.next = null;
        return ltHead;
    }
}