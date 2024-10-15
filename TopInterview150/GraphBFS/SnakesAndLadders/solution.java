/*
You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 are not the starting points of any snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.

 

Example 1:


Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
Example 2:

Input: board = [[-1,-1],[-1,3]]
Output: 1
 

Constraints:

n == board.length == board[i].length
2 <= n <= 20
board[i][j] is either -1 or in the range [1, n2].
The squares labeled 1 and n2 are not the starting points of any snake or ladder.
*/
import java.util.*;




//priority queue and heuristic solution/ ML way
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        //number of moves, current square
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);//lower of the two #ofMoves
            }
            return Integer.compare(b[1], a[1]);//higher of the two squares
        });
        boolean[] visited = new boolean[n*n+1];
        int minMoves[] = new int[n*n+1];//keep track of the minimal moves to reach each square
        Arrays.fill(minMoves, Integer.MAX_VALUE);

        pq.add(new int[]{0, 1});//start at 1 with 0 moves
        visited[1] = true;;
        minMoves[1] = 0;
        
        while (!pq.isEmpty())
        {
            int[] current = pq.poll();
            int moves = current[0];//get # of moves so far
            int currentSquare = current[1];//get currSquare
            //System.out.println(currentSquare);
            if (currentSquare == n*n)
            {
                return moves;//found last square, return moves
            }

            //possible dice rolls, go from 6 to 1 for slight optimization
            for (int i = 6; i > 0; i--)
            {
                int nextSquare = currentSquare + i;
                if (nextSquare > n*n) return moves+1;/////
                
                //System.out.println(currentSquare + ": roll to " + nextSquare + ", moves: " + (moves+1));

                int row = getRow(nextSquare, n);
                int col = getCol(nextSquare, n);
                //System.out.println(row + " " + col);
                if (board[row][col] != -1)
                {
                    nextSquare = board[row][col];//take snake or ladder
                    //System.out.println(board[row][col]);
                    //check if final square
                    if (nextSquare >= n*n) return moves+1;
                }

                //if we can improve the min moves to reach finalSquare
                if (!visited[nextSquare] || moves + 1 < minMoves[nextSquare])
                {
                   // System.out.println(currentSquare + ": roll to " + nextSquare + ", moves: " + (moves+1));
                    visited[nextSquare] = true;
                    minMoves[nextSquare] = moves + 1;
                    pq.add(new int[]{moves+1, nextSquare});//enqueue new moves
                }
            }
            //System.out.println();
        }
        return -1;//if not possible to reach end square
    }
    public int getRow(int squareNum, int sideLength) {
        return sideLength - 1 - (squareNum-1)/sideLength; //get row index
    }
    public int getCol(int squareNum, int sideLength) {
        int row = getRow(squareNum, sideLength);
        int col = (squareNum - 1) % sideLength;
        if ((sideLength - 1 - row) % 2 == 1) //check if we are in even row
        {
            col = sideLength - 1 - col;//reverse every other row for boustrephodon
        }
        return col;
    }
}