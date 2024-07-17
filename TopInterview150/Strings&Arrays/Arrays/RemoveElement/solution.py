class Solution(object):
    def removeElement(self, nums, val):
        counter = 0
        for x in range(len(nums)):
            if (nums[x] != val):
                nums[counter] = nums[x]
                counter+=1
        return counter
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        
