class Solution {
    public:
        int search(vector<int>& nums, int target) {
            if (nums[0] == target) return 0;
            if (nums.size() == 1) return -1;

            int l = 0, r = nums.size()-1;

            while (l <= r) {
                int m = l + (r-l)/2;

                if (nums[m] == target)
                {
                    return m;
                }

                if (nums[l] <= nums[m])//left half sorted
                {
                    if (nums[l] <= target && target < nums[m])//want to look left
                    {
                        r = m-1;
                    }
                    else l = m+1;
                }
                else {
                    if (nums[m] < target && target <= nums[r])
                    {
                        l = m+1;
                    }
                    else r = m-1;
                }
            }

            return -1;
        }
    };