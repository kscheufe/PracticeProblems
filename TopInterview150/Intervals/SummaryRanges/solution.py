class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        start = 0
        output = []
        if len(nums) == 0:
            return output
        for i in range(len(nums)-1):
            if nums[i+1] != nums[i]+1:
                """if next num is not consecutive"""
                if start == i:
                    output.append(str(nums[i]))
                else:
                    output.append(str(nums[start]) + "->" + str(nums[i]))
                
                start = i+1  
        if nums[start] == nums[len(nums)-1]:
            output.append(str(nums[start]))
        else:
            output.append(str(nums[start]) + "->" + str(nums[len(nums)-1]))
        return output;  