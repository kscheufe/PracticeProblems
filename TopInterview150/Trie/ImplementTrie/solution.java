/*
A trie (pronounced as "try") or prefix tree is a tree data structure used 
to efficiently store and retrieve keys in a dataset of strings. There are 
various applications of this data structure, such as autocomplete and 
spellchecker.


Implement the Trie class:
Trie() Initializes the trie object.

void insert(String word) Inserts the string word into the trie.

boolean search(String word) Returns true if the string word is in the 
trie (i.e., was inserted before), and false otherwise.

boolean startsWith(String prefix) Returns true if there is a previously 
inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", 
    "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], 
    ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
*/
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
