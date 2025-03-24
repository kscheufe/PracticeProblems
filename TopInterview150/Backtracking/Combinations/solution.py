class Solution(object):
    
    def backtrack(self, result, comb, n, k, start):
        if len(comb) == k:
            result.append(list(comb))
            return
        
        for i in range(start, n+1):
            comb.append(i)
            self.backtrack(result, comb, n, k, i+1)
            comb.pop()
        
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        
        result = []
        comb = []

        self.backtrack(result, comb, n, k, 1)
        return result
