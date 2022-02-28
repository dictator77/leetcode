/**
 * 1. Problems:
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * Example 2:
 *
 *
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * Example 3:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 *
 * 3. Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 */
/
class Solution {
    /**
     * 1. Approach:
     * Brute force
     * 2. Complexity:
     * Time:O(mnx)
     * Space:O(1)
     */
    /
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    int x = 1;
                    while(square(matrix, i, j, m, n, x)){
                        x++;
                    }
                    res = Math.max(res, (int)Math.pow(x, 2));
                }
            }
        }
        return res;
    }

    private boolean square(char[][] matrix, int a, int b, int m, int n, int x){
        if(a + x >= m || b + x >= n){
            return false;
        }
        for(int i = 0; i <= x; i++){
            if(matrix[a + x][b + i] == '0' || matrix[a + i][b + x] == '0'){
                return false;
            }
        }
        return true;
    }
}


class Solution {
    public int maximalSquare(char[][] matrix) {
        /**
         * 1. Approach:
         * Dynamic programming
         * 2. Complexity:
         * Time:O(mn)
         * Space:O(mn)
         */
        /
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSide = 0;
        if(matrix == null || m == 0 || n == 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]))+1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}