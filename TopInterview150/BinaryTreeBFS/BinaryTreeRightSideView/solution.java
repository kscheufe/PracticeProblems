/*
Given the root of a binary tree, imagine yourself standing on the right 
side of it, return the values of the nodes you can see ordered from top 
to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]

Example 3:
Input: root = []
Output: []
 
Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new LinkedList<>();
        if (root == null) return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int counter;
        while (!queue.isEmpty())
        {
            //get initial number of elements
            counter = queue.size();

            for (int i = 1; i <= counter; i++)
            {
                TreeNode curr = queue.remove();
                if (i == counter)//if the last element of the row
                    output.add(curr.val);
                
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);//add children
            }
        }
        return output;
    }
}
 /*DFS Solution
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new LinkedList<>();
        findRightMostChild(root, 0, output);
        return output;
    }

    public void findRightMostChild(TreeNode root, int height, List<Integer> output)
    {
        if (root == null) return;
        if (height >= output.size())
        {
            output.add(root.val);
        }
        findRightMostChild(root.right, height + 1, output);
        findRightMostChild(root.left, height+1, output);
    }
} */