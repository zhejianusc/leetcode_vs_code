import java.util.List;

/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (30.45%)
 * Total Accepted:    290.1K
 * Total Submissions: 943.2K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> rows = new ArrayList<>();
        if(numRows == 1) return s;
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        boolean goDown = false;;
        int curRow = 0;
        for(int i = 0; i < s.length(); i++) {
            rows.get(curRow).append(s.charAt(i));
            if(curRow == 0 || curRow == numRows - 1 ) goDown = !goDown;
            curRow = goDown ? curRow + 1 : curRow - 1;

        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < rows.size(); i++) {
            res.append(rows.get(i));
        }
        return res.toString();
    }
}

