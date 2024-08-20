class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        num = 0
        signValue = 1
        result = 0
        stack = []

        for char in s:
            if char.isdigit():
                num = num * 10 + int(char)
            elif char == '+' or char == '-':
                result += num*signValue
                signValue = -1 if char == '-' else 1
                num = 0
            elif char == '(':
                stack.append(result)
                stack.append(signValue)
                result = 0
                signValue = 1
            elif char == ')':
                result += signValue*num
                result *= stack.pop()
                result += stack.pop()
                num = 0
        return result + num*signValue
#testcommit