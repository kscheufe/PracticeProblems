class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() > 2)
        {
            int counter = 2;
            for (int i = 2; i<nums.size(); i++)
            {
                if (nums[i] != nums[counter-1] || nums[i] != nums[counter-2])
                {
                    nums[counter] = nums[i];
                    counter++;
                }
            }
            return counter;
        }
        else
        {
            return nums.size();
        }
    }
};