/*
Given an unsorted array of integers nums, return the length of the 
longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        int curr;
        int prev = set.first();
        int counter = 1;
        int output = 1;
        while (iterator.hasNext())
        {
            curr = iterator.next();
            if (curr != set.first())
            {
                if (curr == prev +1)
                {
                    counter++;
                    if (counter > output)
                    {
                        output = counter;
                    }
                }
                else 
                    counter = 1;
            }
            prev = curr;
        }
        return output;
    }
}