class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mySet = set()
        output = 1
        if len(nums) == 0:
            return 0
        for i in nums:
            mySet.add(i)
        for i in mySet:
            if i-1 not in mySet:
                counter = 1
                curr = i
                while curr+1 in mySet:
                    counter+=1
                    curr+=1
                    output = max(output, counter)
        return output