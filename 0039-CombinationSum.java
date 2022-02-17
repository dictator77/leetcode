/**
 * 1. Problems:
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 *
 * 3. Constraints:
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 */
/
class Solution {
    /**
     * 1. Approach:
     * Backtracking
     *
     * 2. Complexity:
     * Time:O(S)
     * Space:O(target)
     * S is the length of all avaliable solutions;
     *
     * 3. Mistakes
     * 1) forget when the condition that sum is larger than target.
     */
    /
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combination(candidates, 0, target, 0);
        return res;
    }
    private void combination(int[] candidates, int index, int target, int now){
        if(now == target){
            res.add(new ArrayList(temp));
            return;
        }
        if(index == candidates.length){
            return;
        }
        if(now > target){
            return;
        }
        temp.add(candidates[index]);
        combination(candidates, index, target, now+candidates[index]);
        temp.remove(temp.size() - 1);
        combination(candidates, index + 1, target, now);
    }
}