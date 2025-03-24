/*
Given an array nums of distinct integers, return all the possible 
permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        backtrack(result, comb, nums);
        return result;
    }

    void backtrack(
        List<List<Integer>> result,
        List<Integer> comb,
        int[] nums
    ) {
        if (comb.size() == nums.length)
        {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i : nums)
        {
            if (comb.contains(i))
                continue;
            
            comb.add(i);
            backtrack(result, comb, nums);
            comb.remove(comb.size()-1);
        }

    }
}