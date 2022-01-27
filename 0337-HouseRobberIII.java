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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] ans = dp(root);
        return Math.max(ans[0], ans[1]);
    }

    // [0] == rob current house, [1] not rob current house
    private int[] dp(TreeNode node) {
        if(node == null) return new int[] {0, 0};
        int[] left = dp(node.left);
        int[] right = dp(node.right);

        int[] cur = new int[2];
        cur[0] = left[1] + right[1] + node.val; // skipping houses directly linked to the current house
        cur[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // free to rob directly or not directly linked houses
        return cur;
    }
}