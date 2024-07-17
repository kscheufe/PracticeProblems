/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
*/
class Solution {
    public int majorityElement(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++)
        {
            counter = 0;
            for (int j = 0; j < nums.length; j++)
            {
                if (nums[j] == nums[i])
                {
                    counter++;///////////////works but n^2
                }
                else counter--;
            }
            if (counter > 0)
            {
                return nums[i];
            }
        }
        return 0;//unreachable from the given problem description
    }
}
//one easy solution is to go through the whole array for each element to see if it's the majority element by incrementing on seeing it and decrementing otherwise, but that would be n^2 time
//if there's only 2 numbers in the array it's easy, but that's not specified
//follow up of O(1) space and O(n) is not intuitively possible without preexisting knowledge of a particular algorithm
//for arrays with few distinct elements, a blacklist counld also be added to speed up the process, reducing the time of the algorithm, which had to be done for the python submission as it timed out a test case