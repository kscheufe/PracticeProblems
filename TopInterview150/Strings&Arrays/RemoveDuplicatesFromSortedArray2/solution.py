class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        counter = 2
        """for x in range(start, end, stepValue)"""
        for x in range(2, len(nums), 1):
            if (nums[x] != nums[counter-1] or nums[x] != nums[counter-2]):
                nums[counter] = nums[x]
                counter+=1
        return counter
