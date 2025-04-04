class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        left = 0
        right = len(matrix )-1
        row = -1

        while left <= right:
            index = left + (right-left)/2

            if matrix[index][0] <= target and target <= matrix[index][len(matrix[index])-1]:
                row = index
                break
            
            if matrix[index][0] < target:
                left = index+1

            else:
                right = index -1


        if row == -1:
            return False

        left = 0
        right = len(matrix[row])-1

        while left <= right:
            index = left + (right-left)/2

            if matrix[row][index] == target:
                return True
            
            if matrix[row][index] <= target:
                left = index + 1

            else:
                right = index - 1
        return False