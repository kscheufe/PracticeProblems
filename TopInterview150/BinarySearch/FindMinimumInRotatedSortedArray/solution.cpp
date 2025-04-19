class Solution {
    public:
        int findMin(vector<int>& nums) {
            if (nums.size()==1) return nums[0];
            int l = 0;
            int r = nums.size()-1;
            if (nums[l] > nums[l+1]) return nums[l+1];
            if (nums[r] < nums[r-1]) return nums[r];

            while (l <= r) {
                int m = l+(r-l)/2;

                if (m == 0 || nums[m] < nums[m-1])
                    {return nums[m];}

                if (nums[m] < nums[r]) {r = m-1;}
                else l = m+1;
            }

            return nums[r];

        }
    };