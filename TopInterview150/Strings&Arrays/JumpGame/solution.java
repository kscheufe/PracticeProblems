/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
*/
class Solution {
    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        //put a single check in for the [0] array case
        if (nums.length == 1)
        {
            return true;
        }
        //iterate through all elements except the last one
        for (int i = 0; i < nums.length-1; i++)
        {
            //if you can't go any further and current value is 0 you're stuck, return false
            if (maxDistance == 0 && nums[i] == 0)
            {
                return false;
            }
            //if there current position offers you more distance than what you have at the moment, jump there and gain that extra distance
            else if (nums[i]>maxDistance)
            {
                maxDistance = nums[i];
            }
            //if you can still travel, do it and decrement maxDistance
            maxDistance -= 1;
        }
        //if you finish traversing the array and still have distance left available, you can reach the end, so return true
        return true;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        boolean cont = false;
        //set the target to the last position
        int targetPointer = nums.length-1;
        //iterate until the target position is the first position (success)
        while (targetPointer > 0)
        {
            //reset continue to false
            cont = false;
            //iterate through the loop from left to right
            for (int i = 0; i < targetPointer; i++)
            {
                //if the current pos + jumpLength is enough to reach the target
                if (i+nums[i] >= targetPointer)
                {
                    //set currentPos as the new target
                    targetPointer = i;
                    //set continue to true
                    cont = true;
                    //iterate the while loop again (GOTO)
                    break;
                }
            }
            //if no jumps to target were found, return false
            if (!cont)
            {
                return false;
            }
        }
        //if target pointer reaches 0, we've found a path, so return true
        return true;
    }
}