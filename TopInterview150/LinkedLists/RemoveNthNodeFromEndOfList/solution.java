/*
Given the head of a linked list, remove the nth node from the end of the 
list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //trivial two-pass solution by finding the number of nodes, then subtracting n, then passing again and setting target-1.next to target+1
        
        //one-pass solution by keeping a list of the past n nodes
        if (head.next == null) return null;//eliminate the only value and return
        int length = 1;
        ListNode targetMinusOne = new ListNode();//target starts at head
        targetMinusOne.next = head;
        ListNode iterator = head;
        while (length < n)//iterate through the offset (from the end) of n
        {
            iterator = iterator.next;
            length++;
        }
        while (iterator.next != null) //iterate until the end
        {
            iterator = iterator.next;
            targetMinusOne = targetMinusOne.next;
        }
        if (targetMinusOne.next == head)//if n was equal to size (i.e., head was target) (and more than one elemnt, since one elements was already handled)
        {
            return head.next;
        }
        ListNode targetPlusOne = targetMinusOne.next;//cut out the target
        targetMinusOne.next = targetPlusOne.next;//idk why but you can't use target.next.next
        return head;
    }
}