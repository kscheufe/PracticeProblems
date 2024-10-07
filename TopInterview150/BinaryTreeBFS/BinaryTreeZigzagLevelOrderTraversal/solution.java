/*
Given the root of a binary tree, return the zigzag level order traversal 
of its nodes' values. (i.e., from left to right, then right to left for 
the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //same as last but alternate whether to add left first or right 
        //first depending on a 1, -1 multiplier
        List<List<Integer>> output = new LinkedList<>();
        if (root == null) return output;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty())//for each level
        {
            depth++;
            q = reverseQueue(q);//reverse q every time, since it will always be constructed "backwards" per level
            int currLength = q.size();
            
            List<Integer> currList = new LinkedList<>();

            for (int i = 1; i <= currLength; i++)
            {
                TreeNode curr = q.remove();
                currList.add(curr.val);

                if (depth % 2 == 0)
                {
                    if (curr.right != null) q.add(curr.right);
                    if (curr.left != null) q.add(curr.left);
                }
                else 
                {
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
            }
            output.add(currList);
        }
        return output;


    }

    //recursive algo for reversing queue, apparently slower than iterative
    //in practice but equivalent for Big O
    public Queue<TreeNode> reverseQueue(Queue<TreeNode> initial)
    {
        if (initial.isEmpty()) return new LinkedList<>();
        TreeNode curr = initial.remove();
        Queue<TreeNode> output = reverseQueue(initial);
        output.add(curr);
        return output;
    }
}