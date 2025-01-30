class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        for i in range(len(digits)-1, -2, -1):
            if i == -1:
                ret = [0]*(len(digits)+1)
                ret[0] = 1
                return ret
            if digits[i] != 9:
                digits[i] += 1
                return digits
            digits[i] = 0
