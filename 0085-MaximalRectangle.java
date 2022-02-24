/**
 * 1. Problems:
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * Example 2:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 * Example 3:
 *
 * Input: matrix = [["1"]]
 * Output: 1
 *
 *
 * 3. Constraints:
 *
 * rows == matrix.length
 * cols == matrix[i].length
 * 1 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 */
/
class Solution {
    /**
     * 1. Approach:
     * convert this problem to 0084 largest rectanglein histogram
     *
     * 2. Complexity:
     * Time:O(mn)
     * Space:O(mn)
     */
    /
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            int[] up = new int[m];
            int[] down = new int[m];
            Arrays.fill(down, m);
            Deque<Integer> stack = new ArrayDeque<>();
            for(int j = 0; j < m; j++){
                while(!stack.isEmpty() && left[stack.peek()][i] >= left[j][i]){
                    down[stack.peek()] = j;
                    stack.pop();
                }
                if(stack.isEmpty()){
                    up[j] = -1;
                }else{
                    up[j] = stack.peek();
                }
                stack.push(j);
            }
            for(int j = 0; j < m; j++){
                res = Math.max(res, (down[j] - up[j] - 1) * left[j][i]);
            }
        }
        return res;
    }
}