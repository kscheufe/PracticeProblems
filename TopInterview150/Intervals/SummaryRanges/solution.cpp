class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        int start = 0;
        vector<string> output;
        if (nums.size() == 0)
            return output;
        for (int i = 0; i < nums.size()-1; i++)
        {
            if (nums[i] + 1 != nums[i+1])//if next isn't conescutive
            {
                if (nums[start] == nums[i])
                {
                    output.push_back(to_string(nums[start]));
                }
                else
                {
                    output.push_back(to_string(nums[start]) + "->" + to_string(nums[i]));
                }
                start = i+1;
            }
        }
        //check last element
        if (nums[start] == nums[nums.size()-1])
        {
            output.push_back(to_string(nums[start]));
        }
        else
        {
            output.push_back(to_string(nums[start]) + "->" + to_string(nums[nums.size()-1]));
        }
        return output;
}
};