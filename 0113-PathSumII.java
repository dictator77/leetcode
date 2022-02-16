/**
 * 1. Problems:
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 *
 * 3. Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
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
     * Depth First Search
     * 2. Complexity:
     * Time:O(N*N)
     * Space:O(N)
     */
    /
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(root.val);
        pathOne(root, targetSum, root.val, temp);
        return res;
    }
    private void pathOne(TreeNode root, int targetSum, int nowSum, List<Integer> list){
        if(root.left == null && root.right == null){
            if(nowSum == targetSum){
                res.add(new ArrayList(list));
            }
            return;
        }
        if(root.left != null){
            list.add(root.left.val);
            pathOne(root.left, targetSum, nowSum + root.left.val, list);
            list.remove(list.size() - 1);
        }
        if(root.right != null){
            list.add(root.right.val);
            pathOne(root.right, targetSum, nowSum + root.right.val, list);
            list.remove(list.size() - 1);
        }
    }
}