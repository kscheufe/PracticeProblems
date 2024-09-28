/*
Design a data structure that follows the constraints of a Least Recently 
Used (LRU) cache.

Implement the LRUCache class:
- LRUCache(int capacity) Initialize the LRU cache with positive size 
  capacity.
- int get(int key) Return the value of the key if the key exists, 
  otherwise return -1.
- void put(int key, int value) Update the value of the key if the key 
  exists. Otherwise, add the key-value pair to the cache. If the number 
  of keys exceeds the capacity from this operation, evict the least 
  recently used key.

The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 10^4
0 <= value <= 10^5
At most 2 * 10^5 calls will be made to get and put.
 */
public class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int key, int val) { this.key = key; this.val = val; }
    ListNode(int key, int val, ListNode next) 
    { 
        this.key = key;
        this.val = val;
        this.next = next; 
    }
}
//proper implementation
class LRUCache {

    public LRUCache(int capacity) {
        
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/*first implementation, missed the part about 0(1) time complexity
class LRUCache {
    int cap;
    int size = 0;
    ListNode head = null;
    ListNode iterator = null;
    ListNode prev = null;
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        iterator = head;
        prev = head;
        if (iterator == null)
        {
            return -1;
        }
        while (iterator != null)
        {
            if (iterator.key == key)//if found
            {
                //handle searching for key in head
                if (iterator == head)
                {
                    return head.val;
                }
                //otherwise, update iterator to be new head
                prev.next = iterator.next;
                iterator.next = head;
                head = iterator;
                //return val
                return iterator.val;
            }
            if (iterator == prev)//first time through the loop
            {
                iterator = iterator.next;
            }
            else {
                iterator = iterator.next;
                prev = prev.next;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //add first node, cap always at least 1
        if (head == null) 
        {
            head = new ListNode(key, value);
            size++;
            return;
        }
        if (cap == 1)
        {
            head.key = key;
            head.val = value;
            return;
        }
        iterator = head;
        prev = head;
        //optimize running, not writing
        //iterate through looking for existance already
        //otherwise 
            //if size is at max, remove end
            //append new to head, update head
        while (iterator != null)
        {
            //if found, update value and move to front
            if (iterator.key == key)
            {
                iterator.val = value;
                //if found in the first value, LL is already correct
                if (iterator == prev) return;
                //otherise pluck iterator and move to front
                prev.next = iterator.next;
                iterator.next = head;
                head = iterator;
                return;
            }
            //advance pointers
            if (iterator == prev)//first time through the loop
            {
                iterator = iterator.next;
            }
            else {
                if (iterator.next == null) break;//means we've checked the last one and not a match
                iterator = iterator.next;
                prev = prev.next;
            }
        }
        //if you reach the end and haven't found it
        //if at max size, remove the end, then add to front
        if (size == cap)
        {
            prev.next = null;
            iterator = new ListNode(key, value);//just reuse iterator pointer, since we're deleting oldest anyways
            iterator.next = head;
            head = iterator;
        }
        else //if not at max size, add to head
        {
            iterator = new ListNode(key, value);//use iterator pointer, last element still had other objects referencing it
            iterator.next = head;
            head = iterator;
            size++;//increment size
        }
    }
} */
//use just a linked list
 /*
 ADDING
while size < capacity
    check for existance of key already
        if exists, make prev point to next and current point to head
        update value field
    otherwise add to head
otherwise
    check for existance of key already
        if exists, make prev point to next and current point to head
        update value field
    otherwise, keep going until you reach the end, remove the last element make new element point to head
  */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */