class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        l = 0
        r = len(nums)-1
        if nums[l]>nums[l+1]:
            return nums[l+1]
        if nums[r-1] > nums[r]:
            return nums[r]
        
        while l <= r:
            m = l+(r-l)/2

            if m == 0 or nums[m] < nums[m-1]:
                return nums[m]
            
            elif nums[r] < nums[m]:
                l = m+1
            else:
                r = m-1
        
        return nums[r]