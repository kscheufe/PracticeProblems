/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/
class Solution {
    public void rotate(int[] nums, int k) {
        int[] numsRotated = new int[nums.length];
        //instantiate and assign new array, copied from input array, because it's auto evaluation checks memory addresses instead of going through the variable name
        for (int i = 0; i < nums.length; i++)
        {
            numsRotated[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++)
        {
            nums[(i+k)%nums.length] = numsRotated[i];
        }  
    }
}

//CHALLENGE: do in place, with O(1) extra space
class Solution {
    public void rotate(int[] nums, int k) {
        //lift out last value(val), 
        //shift array right 1, 
        //replace value(val) at first array position (the open one), 
        //repeat k times
        k = k % nums.length;
        int temp = 0;
        for (int j = 0; j < (k%nums.length); j++)
        {
            temp = nums[nums.length-1];
            for (int i = nums.length-1; i > 0; i--)
            {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
        }
    }
}
//********time limit exceeded on one of 38 tests

//array reversal method, not in place as sub-arrays were easier to implement
//could do in place by modifying the reversal method to include a start and end index, but that seems superfluous at this point
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        //reverse array
        nums = reverseArray(nums);
        //separate first k elements from last length-k elements
        int[] firstArr = new int[k];
        int[] secondArr = new int[nums.length-k];
        for (int i = 0; i < nums.length; i++)
        {
            if (i < k)
            {
                firstArr[i] = nums[i];
            }
            else secondArr[i-k] = nums[i];
        }
        //reverse those two arrays in place
        firstArr = reverseArray(firstArr);
        secondArr = reverseArray(secondArr);
        //join the arrays back together
        for (int i = 0; i < nums.length; i ++)
        {
            if (i < k)
            {
                nums[i] = firstArr[i];
            }
            else nums[i] = secondArr[i-k];
        }
    }
    public int[] reverseArray(int[] nums)
    {
        int temp;
        for (int i = 0; i < nums.length/2; i++)
        {
            //swap the first and last values, moving inwards with each iteration
            temp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = temp;
        }
        return nums;
    }
}