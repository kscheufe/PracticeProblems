class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        stack = []
        operand1 = 0
        operand2 = 0
        for token in tokens:
            if token in ["*", "-", "/", "+"]:
                operand2 = stack.pop()
                operand1 = stack.pop()
                if token == "+":
                    stack.append(operand1+operand2)
                elif token == "-":
                    stack.append(operand1-operand2)
                elif token == "/":
                    result = int(operand1 / operand2) if (operand1/operand2 >= 0) else -(abs(operand1)//abs(operand2))
                    stack.append(result)
                else:
                    stack.append(operand1*operand2)
            else:
                stack.append(int(token))
        return stack.pop()
