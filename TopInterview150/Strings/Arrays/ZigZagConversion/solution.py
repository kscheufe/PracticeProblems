class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1 or numRows > len(s):
            return s

        rows = [""]*numRows
        dir = 1
        rowIndex = 0
        for x in range(len(s)):
            rows[rowIndex] += s[x]
            rowIndex += dir
            if rowIndex % (numRows-1) == 0:
                dir *= -1
        
        return "".join(rows)