/*
 * @lc app=leetcode id=842 lang=java
 *
 * [842] Split Array into Fibonacci Sequence
 *
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/description/
 *
 * algorithms
 * Medium (34.72%)
 * Total Accepted:    9.5K
 * Total Submissions: 27.4K
 * Testcase Example:  '"123456579"'
 *
 * Given a string S of digits, such as S = "123456579", we can split it into a
 * Fibonacci-like sequence [123, 456, 579].
 * 
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers
 * such that:
 * 
 * 
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer
 * type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 * 
 * 
 * Also, note that when splitting the string into pieces, each piece must not
 * have extra leading zeroes, except if the piece is the number 0 itself.
 * 
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot
 * be done.
 * 
 * Example 1:
 * 
 * 
 * Input: "123456579"
 * Output: [123,456,579]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not
 * valid.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 * 
 * 
 * Note: 
 * 
 * 
 * 1 <= S.length <= 200
 * S contains only digits.
 * 
 * 
 */
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(S, 0, res);
        return res;
    }
    private boolean dfs(String S, int pos, List<Integer> res) {
        if(pos == S.length() && res.size() >= 3) {
            return true;
        }
        for(int i = pos; i < S.length(); i++) {
            if(S.charAt(pos) == '0' && i > pos) break;
            String cur = S.substring(pos, i + 1);
            long curNum = Long.parseLong(cur);
            int size = res.size();
            if(curNum > Integer.MAX_VALUE) {
                break;
            }
            if(size >= 2 && res.get(size - 2) + res.get(size - 1) < (int)curNum) {
                break;
            }
            if(size < 2 || res.get(size - 2) + res.get(size - 1) == (int)curNum) {
                res.add(curNum);
                if(dfs(S, i + 1, res)){
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
}

