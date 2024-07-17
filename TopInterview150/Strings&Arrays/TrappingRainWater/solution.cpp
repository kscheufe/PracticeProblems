class Solution {
public:
    int trap(vector<int>& height) {
        if (height.size() <= 2)      
        {
            return 0;
        }

        int left = 0, right = height.size()-1;
        int leftMax = height[0];
        int rightMax = height[right];
        int total = 0;

        while (left < right)
        {
            if (leftMax < rightMax)
            {
                left+=1;
                leftMax = max(leftMax, height[left]);
                total += max(0, leftMax-height[left]);
            }
            else
            {
                right--;
                rightMax = max(rightMax, height[right]);
                total += max(0, rightMax-height[right]);
            }
        }
        return total;
    }
};