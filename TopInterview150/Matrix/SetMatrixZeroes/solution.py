class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        row1zero = False
        col1zero = False
        for x in matrix[0]:
            if x == 0:
                row1zero = True
                break
        for y in matrix:
            if y[0] == 0:
                col1zero = True
                break
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[0])):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[0])):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0

        if col1zero:
            for i in range(len(matrix)):
                matrix[i][0] = 0
        if row1zero:
            for j in range(len(matrix[0])):
                matrix[0][j] = 0