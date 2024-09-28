/*
Given the head of a sorted linked list, delete all nodes that have 
duplicate numbers, leaving only distinct numbers from the original list. 
Return the linked list sorted as well. 

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode iterator = head;
        boolean headSet = false;
        ListNode prefix = null;
        ListNode prev = head;
        //handle empty and length=1 lists
        if (head == null || head.next == null) return head;



        //iterate through the LL
        while (iterator != null)
        {
            iterator = iterator.next;
            
            if (iterator == null)//handles distinct final element
            {
                if (!headSet) return prev;
                prefix.next = prev;
                return head;
            }
            //if previous == iterator, skip all nodes with the same val
            if (prev.val == iterator.val)//if (prev.val == iterator.val) -> changed to while loop after implementing, as now it will rerun if q, q, q, W, W (current two elements are the same)
            {
                while (iterator != null && prev.val == iterator.val)
                {
                    prev = iterator;
                    iterator = iterator.next;//this will end at q, q, Q, W, w, both will advance once by next iteration
                } 
            }
            //if current and previous are distinct, add prev to prefix
            else if (prev.val != iterator.val)
            {
                if (headSet == false)//handle first distinct value
                {
                    head = prev;
                    headSet = true;
                    prefix = head;
                }
                else //normal case is to add new distinct to list and make it the new end
                {
                    prefix.next = prev;
                    prefix = prev;
                }
                //remove the pointer of prefix.next to hinder any persistent nodes on edge cases, any required node will have another pointer on it
                prefix.next = null;
            }
            prev = iterator;
        }
        if (headSet == false) return null;//all numbers same
        return head;
    }
}

/* misunderstanding of the question, so above solution is more optimal
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //num, counter
        HashMap<int, int> counts = new HashMap<>();
        ListNode prefix;
        ListNode iterator = head;
        while (iterator != null)
        {
            //add to hMap
            counts.put(iterator.val, counts.getOrDefault(iterator.val, 0) + 1);
            iterator = iterator.next;
        }
        iterator = head;
        prefix = null;
        while (iterator != null)
        {
            if (counts.get(iterator.val) == 1)
            {
                //if prefix hasn't been set yet (no included values seen)
                if (prefix == null)
                {
                    //set head to point to this value
                    head = iterator;

                }
                //cut any unnecessary nodes
                if (prefix != null)
                {
                    prefix.next = iterator;
                }
                //set prefix
                prefix = iterator;
            }



            iterator = iterator.next;
        }
    }
} */