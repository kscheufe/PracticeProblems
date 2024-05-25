class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        blacklist = []
        for x in range(len(nums)):
            value = nums[x]
            counter = 1
            if blacklist.count(value) > 0:
                continue
            for y in range(len(nums)):
                if nums[x] == nums[y]:
                    counter+=1
                else: 
                    counter -= 1
            if counter > 0:
                return value
            else: 
                blacklist.append(value)
            