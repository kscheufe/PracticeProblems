class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if nums[0] == target:
            return 0
        if len(nums) == 1:
            return -1
        
        l = 0
        r = len(nums)-1

        while l<=r:
            index = l+(r-l)/2

            if (nums[index]== target):
                return index
            
            if nums[l] <= nums[index]:
                if nums[l] <= target and target <= nums[index]:
                    r = index-1
                else:
                    l = index +1
            else:
                if nums[index] <= target and target <= nums[r]:
                    1 = index+1
                else:
                    r = index-1
        return -1