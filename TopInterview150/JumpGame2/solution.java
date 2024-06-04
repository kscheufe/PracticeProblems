/*You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
*/

//start at [0], iterate until you find the first position [n] that can jump to n-1
//increment a counter, rerun the method until you find the first position that can jump to this new position [n]

//greedy BFS solution, fastest, uses more space
class Solution {
    public int jump(int[] nums) {
        int target = nums.length, i = 0, maxReachable = 0, lastJumpedPos = 0, jumps = 0;
        while (lastJumpedPos < target-1)//loop until end position is reached
        {
            if (nums[i]+i > maxReachable)//if we can reach further from this position
            {
                maxReachable = nums[i]+i;//update maxReachable
            }
            if (i == lastJumpedPos) {//if the current search has finished and maxReachable index found
                lastJumpedPos = maxReachable;//jump to maxReachable
                jumps++;//increment the numder of jumps
            }
            i++;
        }
        return jumps;
    }
}

//recursive solution
class Solution {
    public int jump(int[] nums) {
        return solve(nums.length-1, nums);
    }
    public int solve(int target, int[] nums)
    {
        if (target == 0) return 0;
        for (int i = 0; i < target; i++)
        {
            if (i + nums[i] >= target)
            {
                return 1 + solve(i, nums);
            }
        }
        return -1;
    }
}

//iterative solution
class Solution {
    public int jump(int[] nums) {
        int counter = 0;
        int target = nums.length-1;
        while (true)
        {
            if (target==0)//if targetting the first element, return counter, algorithm has completed
            {
                return counter;
            }
            for (int i = 0; i < target; i++)//iterate from the first element...
            {
                //find the earliest jump to the end
                if (nums[i] + i >= target)
                {
                    target = i;//set that position as target
                    counter++;//increment counter
                    break;//rerun search
                }
            }
        }
    }
}