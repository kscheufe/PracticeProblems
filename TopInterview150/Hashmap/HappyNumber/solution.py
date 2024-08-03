class Solution(object):
    
    def sumOfSquares(self, n):
        sum = 0
        while (n > 0):
            digit = n%10
            sum += digit*digit
            n//=10
        return sum
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        set = {-1}
        while n > 1 and n not in set:
            set.add(n)
            n = self.sumOfSquares(n)
        return n==1
    

