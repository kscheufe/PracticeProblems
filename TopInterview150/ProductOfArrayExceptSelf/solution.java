/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/

//could also multiply all numbers together and divide by index i, but that's also disallowed
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        answer[0] = 1;//default set, will revert to 0 if nums[0] == 0
        for (int i = 1; i < nums.length; i++)
        {
            answer[i] = answer[i-1]*nums[i-1];
        }//sets the answer array to the product of all numbers before it

        int revProduct = 1;//default set, will become 0 if it encounters one
        for (int i = nums.length-1; i >= 0; i--)
        {
            //now set the answer array to be the product of all numbers before it (what's already in the array) multiplied by all the numbers after it (skipping itself)
            answer[i] *= revProduct;
            //multiply revProduct for [i-1] 
            revProduct *= nums[i];
        }
        return answer;
    }
}


//O(n^2) solution, O(n) extra space
/*
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            answer[i] = 1;
            for (int j = 0; j < nums.length; j++)
            {
                if (i != j)
                {
                    answer[i] *= nums[j];
                }
            }
            
        }
        return answer;
    }
}
*/