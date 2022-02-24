/**
 * 1. Problems:
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * 3. Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * backtrack
     *
     * 2. Complexity:
     * Time:O(m*n*3^L)
     * Space:O(m*n)
     */
    /
    boolean flag = false;
    boolean[][] flags = new boolean[6][6];
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    flags[i][j] = true;
                    wordSearch(board, i, j, word, 0);
                    flags[i][j] = false;
                    if(flag == true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private void wordSearch(char[][] board, int m, int n, String word, int i){
        if(i == word.length() - 1 && board[m][n] == word.charAt(i)){
            flag = true;
            return;
        }
        if(board[m][n] != word.charAt(i)){
            return;
        }
        if(m - 1 >= 0 && flags[m-1][n] == false){
            flags[m-1][n] = true;
            wordSearch(board, m - 1, n, word, i + 1);
            flags[m-1][n] = false;
        }
        if(n - 1 >= 0 && flags[m][n - 1] == false){
            flags[m][n - 1] = true;
            wordSearch(board, m, n - 1, word, i + 1);
            flags[m][n - 1] = false;
        }
        if(m + 1 < board.length && flags[m + 1][n] == false){
            flags[m + 1][n] = true;
            wordSearch(board, m + 1, n, word, i + 1);
            flags[m + 1][n] = false;
        }
        if(n + 1 < board[0].length && flags[m][n + 1] == false){
            flags[m][n + 1] = true;
            wordSearch(board, m, n + 1, word, i + 1);
            flags[m][n + 1] = false;
        }
    }
}