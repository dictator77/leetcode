/**
 * 1. Problems:
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 *
 * 3. Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 *
 */
/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 1. Approach:
     * Brute Force
     * DFS
     * 2. Complexity:
     * Time:O(n^2)
     * Space:O(n)
     */
    /
    int pathnum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        path(root, targetSum);
        return pathnum;
    }

    private void path(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        DFS(root, targetSum, 0);
        path(root.left, targetSum);
        path(root.right,targetSum);
    }

    private void DFS(TreeNode root, int targetSum, long nowSum){
        if(root == null){
            return;
        }
        nowSum += root.val;
        if(targetSum == nowSum){
            pathnum++;
        }
        DFS(root.left, targetSum, nowSum);
        DFS(root.right, targetSum, nowSum);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 1. Approach:
     * prefix sum and dfs.
     * 2. Complexity:
     * Time:O(n)
     * Space:O(n)
     */
    /

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0l, 1);
        return DFS(root, prefix, targetSum, 0);
    }

    private int DFS(TreeNode root, HashMap<Long, Integer> prefix, int targetSum, long curr){
        if(root == null){
            return 0;
        }
        int ret = 0;
        curr += root.val;
        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += DFS(root.left, prefix, targetSum, curr);
        ret += DFS(root.right, prefix, targetSum, curr);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}