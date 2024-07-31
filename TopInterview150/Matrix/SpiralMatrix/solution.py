class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        top = 0
        left = 0
        bottom = len(matrix)-1
        right = len(matrix[0])-1
        dirX = 1
        dirY = 0
        posX = 0
        posY = 0
        output = []
        for i in range(0,(right+1)*(bottom+1)):
            output.append(matrix[posY][posX])
            if posX == right and dirX == 1:
                dirX = 0
                dirY = 1
                top+=1
            elif posY == bottom and dirY == 1:
                dirX = -1
                dirY = 0
                right-=1
            elif posX == left and dirX == -1:
                dirX = 0
                dirY = -1
                bottom-=1
            elif posY == top and dirY == -1:
                dirX = 1
                dirY = 0
                left+=1
            posX += dirX
            posY += dirY
        return output
