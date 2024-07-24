class Solution(object):
    def minSubArrayLen(self, target, nums):
        """
        :type target: int
        :type nums: List[int]
        :rtype: int
        """
        p1 = 0
        minSize = 1000000000
        currSum = 0
        for p2 in range(len(nums)):
            currSum += nums[p2]
            while (currSum >= target):
                minSize = min(minSize, p2-p1+1)
                currSum -= nums[p1]
                p1+=1
        if minSize == 1000000000:
            return 0
        return minSize