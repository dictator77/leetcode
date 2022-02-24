/**
 * 1. Problems:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * 3. Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * Dynamic programming
     *
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        int max = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > max){
                max = prices[i];
            }else if(prices[i] < min){
                res = Math.max(res, max - min);
                max = prices[i];
                min = prices[i];
            }
        }
        res = Math.max(res, max - min);
        return res;
    }
}