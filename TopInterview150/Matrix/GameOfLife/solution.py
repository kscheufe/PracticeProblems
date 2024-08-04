class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        iBoarder = len(board)-1
        jBoarder = len(board[0])-1
        for i in range(len(board)):
            for j in range(len(board[0])):
                if i != 0 and board[i-1][j]%10 == 1:
                    board[i][j]+=10
                if j != 0 and board[i][j-1]%10 == 1:
                    board[i][j]+=10
                if i != iBoarder and board[i+1][j] %10 == 1:
                    board[i][j]+=10
                if j != jBoarder and board[i][j+1]%10 ==1:
                    board[i][j]+=10
                if i != 0 and j != 0 and board[i-1][j-1] % 10 == 1:
                    board[i][j]+=10
                if i != 0 and j!=jBoarder and board[i-1][j+1]%10 ==1:
                    board[i][j]+=10
                if i != iBoarder and j!=jBoarder and board[i+1][j+1]%10 ==1:
                    board[i][j]+=10
                if i != iBoarder and j!=0 and board[i+1][j-1]%10 ==1:
                    board[i][j]+=10
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if 20 < board[i][j] < 32:
                    board[i][j] = 1
                else:
                    board[i][j] = 0

