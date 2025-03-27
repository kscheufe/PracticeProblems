class Solution(object):
    def backtrack(self, result, comb, candidates, target, start):
        if target == 0:
            result.append(list(comb))
            return
        
        for i in range(start, len(candidates)):
            if candidates[i] <= target:
                comb.append(candidates[i])
                self.backtrack(result, comb, candidates, target-candidates[i], i)
                comb.pop()

    
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        comb = []

        self.backtrack(result, comb, candidates, target, 0)
        return result