/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (27.37%)
 * Total Accepted:    106.4K
 * Total Submissions: 378.3K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * board = [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 * 
 * 
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode p = root;
            for(char c : w.toCharArray()) {
                int idx = c - 'a';
                if(p.children[idx] == null) {
                    p.children[idx] = new TrieNode();
                }
                p = p.children[idx];
            }
            p.word = w;
        }
        return root;
    }
    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char cur = board[i][j];
        if(board[i][j] == '#' || p.children[cur - 'a'] == null) {
            return;
        }
        board[i][j] = '#';
        p = p.children[cur - 'a'];
        if(p.word != null) {
            res.add(p.word);
            p.word = null;
            return;
        }
        if(i - 1 >= 0) {
            dfs(board, i - 1, j, p, res);
        }
        if(i + 1 < board.length) {
            dfs(board, i + 1, j, p, res);
        }
        if(j - 1 >= 0) {
            dfs(board, i, j - 1, p, res);
        }
        if(j + 1 < board[0].length) {
            dfs(board, i, j + 1, p, res);
        }
        board[i][j] = cur;
        
    }
    class TrieNode{
        String word;
        TrieNode[] children = new TrieNode[26];
    }
}

