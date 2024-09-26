/*
Given the head of a linked list, reverse the nodes of the list k at a 
time, and return the modified list.

k is a positive integer and is less than or equal to the length of the 
linked list. If the number of nodes is not a multiple of k then left-out 
nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves 
may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
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
    public ListNode reverseKGroup(ListNode iterator, int k) {
        //trivial case
        if (k == 1) return iterator;
        ListNode lengthChecker;
        boolean kGroup = true;
        ListNode newHead = null;
        
        ListNode kHigh = null;
        ListNode kLow = null;
        ListNode kHighMinusOne = null;
        ListNode prefixTail = null;
        //process all elements
        while (iterator != null)
        {   
            lengthChecker = iterator;
            //check if there's enough elements left for a k group
            for (int i = 0; i < k; i++)
            {
                if (lengthChecker == null) 
                {
                    kGroup = false;
                    break;
                }
                lengthChecker = lengthChecker.next;//iterate lengthChecker
            }
            if (kGroup == false)//handle suffix
            {
                //add suffix to modified list
                prefixTail.next = iterator;
                return newHead;
            }
        //create new k group arrangement

            //we know there are k elements we want to modify
            for (int i = 0; i < k; i++)
            {
                if (i == 0)//if at the start of the k group
                {
                    kHigh = iterator;
                    kLow = iterator;
                    kHighMinusOne = iterator;
                    iterator = iterator.next;
                    kLow.next = null;//get rid of kLow's next pointer, it is unneeded and will be replaced as a prefixTail
                }
                else 
                {
                    kHigh = iterator;
                    iterator = iterator.next;
                    kHigh.next = kHighMinusOne;//set the next node in the list to the head of the current k section
                    kHighMinusOne = kHigh;//update the head of the current segment (left one)
                }                
            }
        //add new k group to list
            //if this is the first group
            if (newHead == null)
            {
                newHead = kHigh;
                prefixTail = kLow;
            }
            else 
            {
                prefixTail.next = kHigh;
                prefixTail = kLow;
            }

        }//outside while

        return newHead;
    }
}

//learned: need to add dummy checker before messing with k groups pointers since its in place
 /*
class Solution {
    public ListNode reverseKGroup(ListNode iterator, int k) {
        if (k==1) return iterator;
        ListNode kHigh = new ListNode();//just needs initialized
        ListNode kLow = new ListNode();//just needs initialized
        ListNode kHighMinusOne = new ListNode();//temp for swapping nodes
        ListNode prefixEnd = iterator;//needs to start at head node in case of only one k group
        ListNode newHead = iterator;
        boolean newHeadSet = false;
        int counter = k;
        while (iterator != null)
        {
            //if start of a k group or suffix
            if (counter == k)//set kPointers to iterator (current node) at the start of each segment
            {
                kLow = iterator;//set the current node as the end of the k-group
                kHigh = iterator;
                kHighMinusOne = iterator;
                iterator = iterator.next;
            }
            //stuff here for handling normal proceeding
            else //counter != k
            {   //when theres an exact k group as a suffix
                if (counter == 1 && iterator.next == null) 
                {
                    //set all k group stuff
                    kHigh = iterator;
                    //iterator = iterator.next;
                    kHigh.next = kHighMinusOne;
                    //append k group
                    if (prefixEnd != newHead)//if there's already been a k-group previously
                    {
                        prefixEnd.next = kHigh;//set the node after prefix end to the current kHigh
                        prefixEnd = kLow;
                        //make kLow (new end element) point to null
                        prefixEnd.next = null;
                        return newHead;//newHead will have been correctly set
                    }
                    else //if there is exactly one k group in the LL
                    {
                        newHead = kHigh;//set the head to the high index
                        kLow.next = null;//ensure there's no loops in the low index
                        return newHead;
                    }
                }
                //default behaviour when there's more elements in the k group or more elements in the incomplete suffix
                else 
                {
                    kHigh = iterator;
                    iterator = iterator.next;
                    if (iterator != null ) {
                        kHigh.next = kHighMinusOne;//set the next node in the list to the head of the current k section
                        kHighMinusOne = kHigh;//update the head of the current segment (left one)
                    }
                }
            }
            
            
            counter--;
            if (counter == 0)//if counter == 0, it's time to swap. In the suffix case of not exactly a k group, this will not be exectued for the last step, REQUIRING AN ADDITIONAL SWAP
            {
                //handle case
                if (newHeadSet == false)//if at the first k group of new LL
                {
                    newHead = kHigh;
                    prefixEnd = kLow;
                    newHeadSet = true;
                }
                else 
                {
                    prefixEnd.next = kHigh;//set the node after prefix end to the current kHigh
                    prefixEnd = kLow;//set prefixEnd to be the lowest (originally first) value of the k group)
                }
                counter = k;//reset counter to k
            }
        }
        
        //CHECK case of not exactly n k-groups
        if (counter != k)//swap the last groups
        {
            prefixEnd.next = kLow;//set the node after prefix end to the current kHigh
        }
        return newHead;
    }
} */