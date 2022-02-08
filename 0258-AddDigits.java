/**
 * 1. Problem:
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 * Example 2:
 *
 * Input: num = 0
 * Output: 0
 *
 *
 * 3. Constraints:
 *
 * 0 <= num <= 231 - 1
 *
 *
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */
/

class Solution {
    /**
     * 1. Approach:
     * Recursion;
     *
     * 2.Complexity
     * Time:O(1)
     * Space:O(1)
     */
    /
    public int addDigits(int num) {
        if(num < 10){
            return num;
        }
        int res = 0;
        while(num > 0){
            res += num % 10;
            num /= 10;
        }
        return addDigits(res);
    }
}

class Solution {
    /**
     * 1. Approach:
     * math
     * 100x+10y+z = 99x+9y+x+y+z
     *
     * 2. Complexity:
     * Time:O(1)
     * Space:O(1)
     */
    /
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}