class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int p1 = 0;
        int minSize = 1000000000;
        int currSum = 0;
        for (int p2 = 0; p2 < nums.size(); p2++)
        {
            currSum += nums[p2];
            while (currSum >= target)
            {
                minSize = min(minSize, p2-p1+1);
                currSum -= nums[p1];
                p1++;
            }
        }
        if (minSize == 1000000000) return 0;
        return minSize;
    }
};