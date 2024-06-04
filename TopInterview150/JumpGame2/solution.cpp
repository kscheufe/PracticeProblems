class Solution {
public:
    int jump(vector<int>& nums) {
        int jumps=0, lastPosition = 0, maxReachable = 0, i = 0, target = nums.size()-1;
        while (lastPosition<target)//iterate through all positions below target
        {
            if (nums[i]+i > maxReachable)//if you can reach further from this node
            {
                maxReachable = nums[i]+i;//update max reachable
            }
            if (i==lastPosition) //if you've iterated to the last Position
            {
                lastPosition = maxReachable;//jump to max reachable
                jumps++;//update jumps accordingly
            }
            i++;//iterate the number of jumps that has to be made
        }
        //when lastPosition (jumped to) is the target, the algorithm has finished, return the number of jumps to get there
        return jumps;

    }
};