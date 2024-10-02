/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child
pointer points to the next node in the list and the left child pointer is 
always null.
The "linked list" should be in the same order as a pre-order traversal of 
the binary tree.
 
Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [0]
Output: [0]

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 *//**
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
//root, left side, right side
//right sides are already on the right
//need to make left siblings (3) point right to right (4)
//then root (2) point right to left sibling {3}
//
//root.left.right = root.right, doing lowest, rightmost nodes first
class Solution {
    public void flatten(TreeNode root) {//, TreeNode nextRight
        if (root == null) return;
        root = moveToRight(root, null);
        
    }

    public TreeNode moveToRight(TreeNode root, TreeNode nextRight)
    {
        if (root == null)//should never happen
        {
            return nextRight;
        }
        else if (root.right == null && root.left == null)//if leaf
        {
            root.right = nextRight;//set the next right value
        }
        else if (root.right != null && root.left != null)//two children
        {
            nextRight = moveToRight(root.right, nextRight);//evaluate right side
            root.right = moveToRight(root.left, nextRight);//evaluate left side
        }
        else if (root.right == null)
        {
            root.right = moveToRight(root.left, nextRight);//left child only
        }
        else if (root.left == null)
        {
            root.right = moveToRight(root.right, nextRight);//right child only
        }
        root.left = null;//clear the left value after it's moved to the right
        return root;
    }
}