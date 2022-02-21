/**
 * 1. Problems:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * 3. Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
/
class Solution {
    /**
     * 1. Approach:
     * firstly, find the highest height, then from two sides to compute the water capacity.
     *
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public int trap(int[] height) {
        int highindex = 0;
        for(int i = 0; i < height.length; i++){
            if(height[highindex] < height[i]){
                highindex = i;
            }
        }
        int index = 0;
        int res = 0;
        for(int i = 0; i < highindex; i++){
            if(height[index] < height[i]){
                index = i;
            }else{
                res += height[index] - height[i];
            }
        }
        index = height.length - 1;
        for(int i = height.length - 1; i > highindex; i--){
            if(height[index] < height[i]){
                index = i;
            }else{
                res += height[index] - height[i];
            }
        }
        return res;
    }
}