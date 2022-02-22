/**
 * 1. Problems:
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * 3. Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
/
class Solution {
    /**
     * 1. Approach:
     * rotate from outside to inside, and every time exchange four nums.
     * 2. Complexity:
     * Time:O(n * n)
     * Space:O(1)
     * 3. Mistakes & improvement:
     * 1) every time exchange should not rotate the last square again.
     */
    /
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++){
            rotation(matrix, i, n);
        }
    }
    private void rotation(int[][] matrix, int index, int n){
        int temp = 0;
        for(int i = index; i < n - index - 1; i++){
            temp = matrix[n - 1 - i][index];
            matrix[n - 1 - i][index] = matrix[n - 1 - index][n - 1 - i];
            matrix[n - 1 - index][n - 1 - i] = matrix[i][n - 1 - index];
            matrix[i][n - 1 - index] = matrix[index][i];
            matrix[index][i] = temp;
        }
    }
}