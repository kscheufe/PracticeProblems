class Solution(object):
    def backtrack(self, result, comb, n, open, close):
        if (len(comb) == n*2):
            result.append(comb[:])
            return
        
        if open < n:
            self.backtrack(result, comb + '(', n, open+1, close)

        if close < open:
            self.backtrack(result, comb + ')', n, open, close+1)
    
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = []
        comb = ""
        self.backtrack(result, comb, n, 0, 0)
        return result
