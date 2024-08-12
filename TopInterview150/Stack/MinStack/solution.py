class MinStack(object):

    
    def __init__(self):
        self.st = []
        self.minSt = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.st.append(val)
        if len(self.minSt) == 0 or val <= self.minSt[-1]:
            self.minSt.append(val)

        

    def pop(self):
        """
        :rtype: None
        """
        temp = self.st[-1]
        if temp == self.minSt[-1]:
            self.minSt.pop()
        self.st.pop()
        

    def top(self):
        """
        :rtype: int
        """
        return self.st[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.minSt[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()