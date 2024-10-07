/*
Given the root of a binary search tree, and an integer k, return the kth 
smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 
Follow up: If the BST is modified often (i.e., we can do insert and 
delete operations) and you need to find the kth smallest frequently, how 
would you optimize?
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//trivial solution would be to preorder traversal to build a list
//node values are all positive, use that?
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;
        while (current != null || !stack.isEmpty())//only break when checking the null value after the biggest one, shouldn't happen
        {
            //reach leftmost child of current
            while (current != null)
            {
                stack.push(current);
                current = current.left;
            }

            //process next node, goes up a level if current is null from checking a non-existant right val
            current = stack.pop();
            count++;

            if (count == k) return current.val;//found node
            
            //check right side
            current = current.right;
        }
        return -1;//should not happen
    }
}