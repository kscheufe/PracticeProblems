class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        for x in range(len(board)):
            rowSet = set()
            for y in range(len(board)):
                if board[x][y] in rowSet:
                    return False
                elif board[x][y] != ".":
                    rowSet.add(board[x][y])
        
        for x in range(len(board)):
            colSet = set()
            for y in range(len(board)):
                if board[y][x] in colSet:
                    return False
                elif board[y][x] != ".":
                    colSet.add(board[y][x])

        for k in range(9):
            boxSet = set()
            for x in range(3):
                for y in range(3):
                    if board[x + 3*(k%3)][y + 3*(k//3)] in boxSet:
                        return False
                    elif board[x + 3*(k%3)][y + 3*(k//3)] != ".":
                        boxSet.add(board[x + 3*(k%3)][y + 3*(k//3)])
        return True