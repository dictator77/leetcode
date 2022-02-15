/**
 * 1. Problems:
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * 3. Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
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
     * preorder
     * 2. Complexity:
     * Time:O(N)
     * Space:O(1)
     */
    /
    int res = 0;
    public int maxDepth(TreeNode root) {
        preOrder(root, 0);
        return res;
    }

    private void preOrder(TreeNode root, int depth){
        if(root == null){
            res = Math.max(res, depth);
            return;
        }
        preOrder(root.left, depth + 1);
        preOrder(root.right, depth + 1);
    }
}