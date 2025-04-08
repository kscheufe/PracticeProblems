class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        r = len(nums)-1
        l = 0
        if len(nums) == 1 or nums[0] > nums[1]:
            return 0
        if nums[r] > nums[r-1]:
            return r
        
        while l < r:
            if l==r:
                return l
            index = l + (r-l)/2

            if nums[index] > nums[index-1] and nums[index] > nums[index+1]:
                return index
            
            elif nums[index] > nums[index+1]:
                r = index-1
            else:
                l = index+1
        
        return -1
        