/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

/*
Initial analysis
- Seems to be an n^2 top down method 
- O(n) solution if you pass through the array from left to right, storing
  the max left value for each position in another arr, then pass from
  right to left, storing the max right value for each position. then you
  can use a formula to calculate the water height at each position with
  another pass. 3 pass solution

 */

//three pass solution
class Solution {
    public int trap(int[] height) {
        int[] maxLeftHeight = new int[height.length];
        int[] maxRightHeight = new int[height.length];
        maxLeftHeight[0] = 0;
        maxRightHeight[height.length-1] = 0;
        int currentMax = 0;
        //forward pass for maxLeft
        for (int i = 0; i < height.length; i++)
        {
            maxLeftHeight[i] = currentMax;
            if (height[i]>currentMax)
            {
                currentMax = height[i];
            }
        }
        currentMax = 0;
        //backward pass for maxRight
        for (int i = height.length - 1; i >= 0; i--)
        {
            maxRightHeight[i] = currentMax;
            if (height[i]>currentMax)
            {
                currentMax = height[i];
            }
        }
        int total = 0;
        //forward or backward pass for each position
        for (int i = 0; i < height.length; i++)
        {
            if (maxLeftHeight[i] > height[i] && maxRightHeight[i] > height[i])
            {
                //water stored in this column will be min of (leftMax, rightMax) - height[i]
                total += Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
            }
        }
        return total;
    }
}
 //n^2 top down method
 //works but is not efficient enough
 /*
 class Solution {
    public int trap(int[] height) {
        if (height.length < 3)
        { return 0; }

        int level = 0;
        //get max height
        for (int i = 0; i < height.length; i++)
        {
            if (height[i] > level)
            level = height[i];
        }
        //check the amount of water stored at each level
        int startIndex = -1;
        int total = 0;
        for (int i = level; i > 0; i--)//at each height
        {
            for (int j = 0; j < height.length; j++)//iterate through the array
            {
                //if the startIndex has not been found
                //and the current height is at current level
                if (height[j] >= i && startIndex == -1)
                {
                    startIndex = j;//initialize startIndex
                }
                //if it has been found
                //and the current height is at current level
                else if (height[j] >= i)
                {
                    total += j-startIndex-1;//increment the water level for each index in between the startIndex and current
                    startIndex = j;//update the startIndex
                }
            }
            startIndex = -1;//reset startIndex
        }
        return total;
    }
}
*/
