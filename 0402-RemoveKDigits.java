/**
 * 1. Problems:
 * Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 *
 * 3. Constraints:
 *
 * 1 <= k <= num.length <= 105
 * num consists of only digits.
 * num does not have any leading zeros except for the zero itself.
 */
class Solution {
    /**
     * 1. Approach:
     * greedy algorithm, every step remove one digit.
     * 2. Complexity:
     * Time:O(n*k)
     * Space:O(n)
     */
    /
    public String removeKdigits(String num, int k) {
        String res = num;
        while(k > 0){
            //System.out.println(res);
            res = removeOneDigit(res);
            k--;
        }
        int index = -1;
        for(int i = 0; i < res.length(); i++){
            if(res.charAt(i) != '0'){
                //System.out.println(i);
                index = i;
                break;
            }
        }
        if(index == -1){
            res = "0";
        }else{
            res = res.substring(index, res.length());
        }
        return res;
    }
    private String removeOneDigit(String num){
        if(num.length() == 1){
            return "0";
        }
        if(num.length() == 2){
            return "" + Math.min(num.charAt(0) - '0', num.charAt(1) - '0');
        }
        int index = 0;
        for(int i = 1; i < num.length(); i++){
            if(num.charAt(i - 1) <= num.charAt(i)){
                index = i;
            }else{
                break;
            }
        }
        if(index == num.length() - 1){
            return num.substring(0, index);
        }else{
            return num.substring(0, index) + num.substring(index + 1, num.length());
        }
    }
}
