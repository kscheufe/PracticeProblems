/*
You are given two non-empty linked lists representing two non-negative 
integers. The digits are stored in reverse order, and each of their 
nodes contains a single digit. Add the two numbers and return the sum as 
a linked list.

You may assume the two numbers do not contain any leading zero, except 
the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answerHead = new ListNode((l1.val+ l2.val) %10);
        ListNode answer = answerHead;
        int carry = (l1.val+l2.val) / 10;//determine the carry
        //handle all cases where both numbers are existant
        while (l1.next != null && l2.next != null)
        {
            l1 = l1.next; l2 = l2.next;//advance l1 and l2
            answer.next = new ListNode((l1.val+l2.val + carry)%10);//set answer.next
            answer = answer.next;//update pointer to point to tail
            carry = (l1.val+l2.val + carry) / 10;//find next carry
        }
        //handle cases where l1 has more digits
        while (l1.next != null)
        {
            l1 = l1.next;
            answer.next = new ListNode((l1.val + carry) % 10);
            answer = answer.next;
            carry = (l1.val+carry) /10;
        }
        //handle cases where l1 has more digits
        while (l2.next != null)
        {
            l2 = l2.next;
            answer.next = new ListNode((l2.val + carry) % 10);
            answer = answer.next;
            carry = (l2.val+carry) /10;
        }
        //check if there's a final carry
        if (carry != 0)
        {
            answer.next = new ListNode((carry));
        }
        return answerHead;
    }
}