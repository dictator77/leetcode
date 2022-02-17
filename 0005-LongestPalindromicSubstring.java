/**
 * 1. Problems:
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * 3. Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
class Solution {
    /**
     * 1. Approach:
     * Dynamic Programming
     * P(i,j) = P(i+1,j-1)^(Si == Sj)
     * 2. Complexity:
     * Time:O(n*n)
     * Space:O(1)
     * 3. Mistakes & improvements:
     * 1) firstly I use a string temp to record every Palindromic Substring then my space complexity will be O(n*n)
     * It's better to record the start and end index of every palindromic substring, then use the
     * String.substring(start, end) to get the substring. PS in the method String.substring() you will not get the char
     * at end index.
     */
    /
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        String res = "";
        if(s.charAt(0) == s.charAt(1)){
            res = s.charAt(0) + res + s.charAt(1);
        }else{
            res = s.charAt(0) + res;
        }
        for(int i = 2; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1) && s.charAt(i) != s.charAt(i - 2)){
                continue;
            }
            if(s.charAt(i) == s.charAt(i - 1)){
                int left = i - 1;
                int right = i;
                int temp = 0;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    temp += 2;
                    left--;
                    right++;
                }
                if(res.length() < temp){
                    res = s.substring(left + 1, right);
                }
            }
            if(s.charAt(i) == s.charAt(i - 2)){
                int left = i - 2;
                int right = i;
                int temp = 1;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                    temp += 2;
                    left--;
                    right++;
                }
                if(res.length() < temp){
                    res = s.substring(left + 1, right);
                }
            }
        }
        return res;
    }
}