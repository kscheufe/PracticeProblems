/*
Given an m x n board of characters and a list of strings words, return all 
words on the board.

Each word must be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. The same 
letter cell may not be used more than once in a word.

 
Example 1:
Input: board = [
["o","a","a","n"],
["e","t","a","e"],
["i","h","k","r"],
["i","f","l","v"]], 
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 
Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
*/
import java.util.*;
class Solution {
    Set<String> checked = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        checked.add("");
        List<String> output = new LinkedList<>();
        Trie tr = new Trie();

        //create the trie from String[] words
        for (String word : words)
            tr.insert(word);

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        //search from each position on board for a string in words
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)//each square
            {
                dfs(board, visited, "", i, j, tr, output);
            }
        }

        return output;
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie tr, List<String> output)
    {
        //boundary and visited checks
        if ( i < 0 || i >= board.length ||
             j < 0 || j >= board[0].length || visited[i][j] )
        {
            return;
        }
        str += board[i][j];//add current char to string path
        
        if (!tr.startsWith(str)) return;//if not a prefix

        //if the string is in trie and not in the output already
        if (tr.search(str) && !checked.contains(str)) {
            output.add(str);
            checked.add(str);
        }

        visited[i][j] = true;//mark curr cell as visited

        //dfs each direction
        dfs(board, visited, str, i-1, j, tr, output);
        dfs(board, visited, str, i+1, j, tr, output);
        dfs(board, visited, str, i, j-1, tr, output);
        dfs(board, visited, str, i, j+1, tr, output);

        visited[i][j] = false;//when backtracking, unmark the current cell
    }
}

class Trie {

    class Node {
        private boolean isWord;
        private Node[] child;
        
        public Node() {
            isWord = false;
            child = new Node[26];
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node head = root;

        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i)-'a';//indices 0-25

            if (head.child[index] == null) head.child[index] = new Node();

            head = head.child[index];//update head pointer to current letter
        }

        head.isWord = true;//set the last character to a word marker
    }
    
    public boolean search(String word) {
        Node head = root;
        for (int i = 0; i < word.length(); i++)
        {
            int index = word.charAt(i)-'a';
            if (head.child[index] == null) return false;
            head = head.child[index];
        }

        return head.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node head = root;
        for (int i = 0; i < prefix.length(); i++)
        {
            int index = prefix.charAt(i)-'a';
            if (head.child[index] == null) return false;
            head = head.child[index];
        }

        return true;
    }

    
}
