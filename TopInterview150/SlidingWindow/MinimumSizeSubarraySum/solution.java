/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n))
 */
//optimal solution
 class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int p1 = 0; 
        int minSize = Integer.MAX_VALUE;
        int currSum = 0;
        for (int p2 = 0; p2 < nums.length; p2++)
        {
            currSum += nums[p2];
            while (currSum >= target)
            {
                minSize = Math.min(minSize, p2-p1+1);
                currSum -= nums[p1];
                p1++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}


 //O(n) solution but with convoluted extra steps from learning the algorithm
/*
 class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //get the first subarray that meets the condition
        int sum = 0;
        int p1 = 0, p2;
        for (p2 = 0; p2 < nums.length; p2++)
        {
            sum += nums[p2];
            if (sum >= target) break;
        }
        if (sum < target) return 0;
        //slide the window, removing the first element if still above threshold
        int minSize = p2-p1+1;
        System.out.println(sum + ", " + p1 + ", " + p2 + ", " + minSize);
        //shorten the front
        while (true)
        {
            if (sum - nums[p1] >= target)
            {
                sum -= nums[p1];
                p1++; 
                if (p2-p1+1 < minSize) {minSize = p2-p1+1;}
                System.out.println(sum + ", " + p1 + ", " + p2 + ", " + minSize);
                continue;
            }
            else {
                System.out.println(sum + ", " + p1 + ", " + p2 + ", " + minSize + ", can't be shortened more");
                break;
            }
        }

        p2++;
        for (; p2 < nums.length; p2++)
        {
            
            sum += nums[p2];
            //whenever you remove the first element, continue checking the new first element to see if it can be removed until it can't
            while (true)
            {
                if (sum - nums[p1] >= target)
                {
                    sum -= nums[p1];
                    p1++; 
                    if (p2-p1+1 < minSize) {minSize = p2-p1+1;}
                    System.out.println(sum + ", " + p1 + ", " + p2 + ", " + minSize);

                    continue;
                }
                
                else {
                    System.out.println(sum + ", " + p1 + ", " + p2 + ", " + minSize + ", can't be shortened more");
                    break;
                }
                
            }

        }
        return minSize;
        
    }
}
*/