/*
Given an array of integers nums sorted in non-decreasing order, find the 
starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */

 class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int[] output = {-1, -1};

        while (l <= r) 
        {
            int index = l + (r-l)/2;

            if (nums[index] == target) {
                if (index == 0) {
                    output[0] = index;
                    break;
                }
                else if (nums[index-1] != target) {
                    output[0] = index;
                    break;
                }
                //else
                r = index -1;
            }
            else if (nums[index] < target) l = index+1;
            else r = index-1;
        }
        if (output[0] == -1) return output;
        l = output[0];
        r = nums.length-1;
        while (l <= r) 
        {
            int index = l + (r-l)/2;

            if (nums[index] == target) {
                if (index == nums.length-1) {
                    output[1] = index;
                    break;
                }
                else if (nums[index+1] != target) {
                    output[1] = index;
                    break;
                }
                //else
                l = index +1;
            }
            else if (nums[index] < target) l = index+1;
            else r = index-1;
        }

        return output;
    }
}