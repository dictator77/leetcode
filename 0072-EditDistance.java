/**
 * 1. Problems:
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * 3. Constraints:
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * Dynamic Programming
     * 2. Complexity:
     * Time:O(m*n)
     * Space:O(m*n)
     */
    /
    public int minDistance(String word1, String word2) {
        int m = word1.length() + 1;
        int n = word2.length() + 1;
        int[][] find = new int[m][n];
        for(int i = 0; i < m; i++){
            find[i][0] = i;
        }
        for(int i = 0; i < n; i++){
            find[0][i] = i;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    find[i][j] = Math.min(Math.min(find[i - 1][j], find[i][j - 1]), find[i - 1][j - 1] - 1) + 1;
                }else{
                    find[i][j] = Math.min(Math.min(find[i - 1][j], find[i][j - 1]), find[i - 1][j - 1]) + 1;
                }
            }
        }
        return find[m - 1][n - 1];
    }
}