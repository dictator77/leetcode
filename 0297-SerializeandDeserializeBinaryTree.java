/**
 * 1. Problems:
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * 3. Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 *
 */
/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    /**
     * 1. Approach:
     * Convert TreeNode to String by BFS.
     * And convert String to TreeNode by using deque.
     * 2. Complexity:
     * Time:O(n)
     * Space:O(n)
     * 3. Mistakes & Improvements:
     * 1) The value of treeNode is not only one char. So should use a mark to notify each node's value and then split it to string arrays;
     */
    /

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        String res = new String();
        dq.offer(root);
        while(!dq.isEmpty()){
            TreeNode temp = dq.poll();
            if(temp == null){
                res = res + '_' + ',';
            }else{
                res = res + temp.val + ',';
                dq.offerLast(temp.left);
                dq.offerLast(temp.right);
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        if(dataArray.length == 1){
            return null;
        }
        TreeNode temp = new TreeNode(Integer.valueOf(dataArray[0]));
        TreeNode head = temp;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerLast(temp);
        int i = 1;
        while(!dq.isEmpty()){
            temp = dq.poll();
            if(dataArray[i].equals("_")){
                temp.left = null;
                i++;
            }else{
                temp.left = new TreeNode(Integer.valueOf(dataArray[i]));
                dq.offerLast(temp.left);
                i++;
            }
            if(dataArray[i].equals("_")){
                temp.right = null;
                i++;
            }else{
                temp.right = new TreeNode(Integer.valueOf(dataArray[i]));
                dq.offerLast(temp.right);
                i++;
            }
        }
        return head;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));