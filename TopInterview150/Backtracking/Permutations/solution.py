class Solution(object):
    def backtrack(self, result, comb, nums):
        if len(comb) == len(nums):
            result.append(comb[:])# or .append(List(comb))
            return
        
        for i in nums:
            if i in comb:
                continue
            comb.append(i)
            self.backtrack(result, comb, nums)
            comb.pop()

    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        self.backtrack(result, [], nums)
        return result
        
