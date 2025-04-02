class Solution {
    public:
        int searchInsert(vector<int>& nums, int target) {
            int left = 0;
            int right = nums.size()-1;

            while (left <= right)
            {
                int index = left + (right-left)/2;
                if (nums[index] == target) return index;
                if (nums[index] < target) left = index + 1;
                else right = index-1;
            }
            return left;
        }
    };