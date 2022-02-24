/**
 * 1. Problems:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * Example 2:
 *
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * Example 3:
 *
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 * 3. Constraints:
 *
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 1. Approach:
     * change the node.val to notify whether this node is visited.
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode node = head;
        while(node.next != null){
            if(node.val == Integer.MAX_VALUE){
                return true;
            }
            node.val = Integer.MAX_VALUE;
            node = node.next;
        }
        return false;
    }
}

public class Solution {
    /**
     * 1. Approach:
     * two pointers. One move one step every time while the other move two steps every time.
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}