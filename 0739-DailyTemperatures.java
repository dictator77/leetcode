/**
 * 1. Problems:
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *  
 * 2. Examples:
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *  
 *
 * 3. Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * stack
     * 2. Complexity:
     * Time:O(n)
     * Space:O(n)
     */
    /
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    ans[stack.peek()] = i - stack.peek();
                    stack.poll();
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            ans[stack.peek()] = 0;
            stack.poll();
        }
        return ans;
    }
}