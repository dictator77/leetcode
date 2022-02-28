/**
 * 1. Problems:
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 *
 * 3. Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 1. Approach:
     * firstly, find the index of the right part by using two pointers.Then, reverse the right part and reverse both parts
     * to find out whether they are the same.
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = slow;
        while(fast != null){
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                fast = fast.next;
            }
            temp = slow;
            slow = slow.next;
        }
        slow = reverse(slow);
        temp.next = null;
        ListNode h1 = head;
        ListNode h2 = slow;
        boolean flag = true;
        while(h2 != null){
            if(h1.val != h2.val){
                flag = false;
                break;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        slow = reverse(slow);
        temp.next = slow;
        return flag;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}