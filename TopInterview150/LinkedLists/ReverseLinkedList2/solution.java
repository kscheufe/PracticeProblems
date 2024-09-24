/*
Given the head of a singly linked list and two integers left and right 
where left <= right, reverse the nodes of the list from position left to 
position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 

Follow up: Could you do it in one pass?
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //handle no middle section
        if (left == right)
            return head;
        int middleSectionLength = right-left;
        ListNode iterator = head;
        ListNode prefixTail = head;//default if there is no prefix
        ListNode rootLow;
        int leftCopy = left;
        ListNode rootHigh = head;//will never be used as head, but needed to initialize it
        //prefix and suffix are easy to create copies of
        //create the middle section by creating the first node (2), then 
        //creating 3 and assigning nextNode as 2. this will require an extra
        //pointer for 2, to eventually add the suffix to, and a pointer for
        //the head of the new section
        
        //left and right are 1 BASED POSITIONS
        while (left > 1)
        {
            if (left == 2)//once you reach the end of the prefix, set the prefixTail
                prefixTail = iterator;

            iterator = iterator.next;
            left--;
        }
        rootLow = new ListNode(iterator.val);//create new rootLow
        //start the pointer at the current low to build the list
        ListNode rootHighMinus1 = rootLow;
        while (middleSectionLength > 0)
        {
            iterator = iterator.next;//advance to next node
            rootHigh = new ListNode(iterator.val, rootHighMinus1);//add new node to the root section
            rootHighMinus1 = rootHigh;//update pointer
            middleSectionLength--;
        }
        //overwrite with the new LL, checking if a prefix existed or not
        if (leftCopy != 1)
            prefixTail.next = rootHigh;//or RH-1 since they're the same now
        else
            head = rootHigh;
        rootLow.next = iterator.next;//copy the suffix
        return head;
    }
}