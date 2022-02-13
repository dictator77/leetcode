/**
 * 1. Problems:
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
/
class Solution {
    /**
     * 1. Approach:
     * Dyanamic Programming
     * 2. Complexity:
     * Time:O(n*2^n)
     * Space:O(n)
     */
    /
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> initSub = new ArrayList<>();
        res.add(initSub);
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            int time = res.size();
            for(int j = 0; j < time; j++){
                List<Integer> list = res.get(j);
                List<Integer> sub = new ArrayList<>(list);
                sub.add(x);
                res.add(sub);
            }
        }
        return res;
    }
}