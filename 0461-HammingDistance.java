/**
 * 1. Problems:
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, return the Hamming distance between them.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * Example 2:
 *
 * Input: x = 3, y = 1
 * Output: 1
 *
 *
 * 3. Constraints:
 *
 * 0 <= x, y <= 231 - 1
 */
/
class Solution {
    /**
     * 1. Approach:
     * brute force
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     * n is the length of x and y which has been convert to binary.
     */
    /
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x != 0 || y != 0){
            if((x & 1) != (y & 1)){
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        return count;
    }
}