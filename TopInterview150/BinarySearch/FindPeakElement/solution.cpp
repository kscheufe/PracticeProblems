class Solution {
    public:
        int findPeakElement(vector<int>& nums) {
            int left = 0;
            int right = nums.size() - 1;
    
            while (left <= right) {
                int index = left + (right - left) / 2;
    
                bool isPeak = true;
    
                if (index > 0 && nums[index] <= nums[index - 1]) isPeak = false;
                if (index < nums.size() - 1 && nums[index] <= nums[index + 1]) isPeak = false;
    
                if (isPeak) {
                    return index;
                }
                
                if (index > 0 && nums[index] < nums[index - 1]) {
                    right = index - 1;
                } 
                else {
                    left = index + 1;
                }
            }
            
            return -1;
        }
    };
    