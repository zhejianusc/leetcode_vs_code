/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (26.52%)
 * Total Accepted:    152.3K
 * Total Submissions: 565.5K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> map = new HashMap<>();
        return dfs(s, 0, dict, map);
        
    }
    private List<String> dfs(String s, int start, Set<String> dict, Map<Integer, List<String>> map) {
        if(map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if(start == s.length()) {
            res.add("");
        }
        for(int i = start; i < s.length(); i++) {
            if(dict.contains(s.substring(start, i + 1))) {
                List<String> prev = dfs(s, i + 1, dict, map);
                for(String l : prev) {
                    res.add(s.substring(start, i + 1) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;

    }
}

