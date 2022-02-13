/**
 * 1. Problem:
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Given a string s, return the power of s.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * Example 2:
 *
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 *
 *
 * 3. Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters.
 */
/

class Solution {
    /**
     * 1. Approach:
     * two pointers
     *
     * 2. Complexity:
     * Time:O(N)
     * Space:O(1)
     */
    /
    public int maxPower(String s) {
        int res = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            if(s.charAt(i) != s.charAt(j)){
                res = Math.max(res, j - i);
                i = j;
            }
            if(j == s.length() - 1){
                res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}