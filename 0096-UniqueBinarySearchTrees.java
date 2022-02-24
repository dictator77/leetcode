/**
 * 1. Problems:
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: 5
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * 3. Constraints:
 * 1 <= n <= 19
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * Dynamic programming
     * fn = fn-1 * f0 + ... + fn-i * fi-1 + ... + f0 * fn-1
     *
     * 2. Complexity:
     * Time:O(n*n)
     * Space:O(n)
     */
    /
    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for(int i = 1; i <= n; i++){
            int temp = 0;
            for(int j = i; j > 0; j--){
                temp += f[j - 1] * f[i - j];
            }
            f[i] = temp;
        }
        return f[n];
    }
}