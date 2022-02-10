/**
 * 1. Problems:
 * Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:
 *
 * If the current number is even, you have to divide it by 2.
 *
 * If the current number is odd, you have to add 1 to it.
 *
 * It is guaranteed that you can always reach one for all test cases.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: s = "1101"
 * Output: 6
 * Explanation: "1101" corressponds to number 13 in their decimal representation.
 * Step 1) 13 is odd, add 1 and obtain 14.
 * Step 2) 14 is even, divide by 2 and obtain 7.
 * Step 3) 7 is odd, add 1 and obtain 8.
 * Step 4) 8 is even, divide by 2 and obtain 4.
 * Step 5) 4 is even, divide by 2 and obtain 2.
 * Step 6) 2 is even, divide by 2 and obtain 1.
 * Example 2:
 *
 * Input: s = "10"
 * Output: 1
 * Explanation: "10" corressponds to number 2 in their decimal representation.
 * Step 1) 2 is even, divide by 2 and obtain 1.
 * Example 3:
 *
 * Input: s = "1"
 * Output: 0
 *
 *
 * 3. Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of characters '0' or '1'
 * s[0] == '1'
 */
/
class Solution {
    /**
     * 1. Approach:
     * Traverse to count
     *
     * 2.Complexity:
     * Time:O(N)
     * Space:O(1)
     */
    /
    public int numSteps(String s) {
        int count = 0;
        int index1 = 0;
        int index0 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                index1 = i;
                break;
            }
        }
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '1'){
                index0 = i + 1;
                break;
            }
        }
        for(int i = index1; i < index0; i++){
            if(s.charAt(i) == '0'){
                count++;
            }
        }
        int res = s.length() - index1 + count + 1;
        if(index0 == index1 + 1){
            res-=2;
        }
        return res;
    }
}