/**
 * 1. Problems:
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * 3. Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
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
     * merge sort
     * 2. Complexity:
     * Time:O(nlogn)
     * Space:O(1)
     */
    /
    public ListNode sortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        for(int subLength = 1; subLength < length; subLength*=2){
            ListNode prev = dummyHead;
            ListNode curr = prev.next;
            while(curr != null){
                ListNode head1 = curr;
                for(int i = 1; i < subLength && curr.next != null; i++){
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for(int i = 1; i < subLength && curr != null && curr.next != null; i++){
                    curr = curr.next;
                }
                ListNode next = null;
                if(curr != null){
                    next = curr.next;
                    curr.next = null;
                }
                curr = next;
                prev.next = merged(head1, head2);
                while(prev.next != null){
                    prev = prev.next;
                }
            }
        }
        return dummyHead.next;
    }

    private ListNode merged(ListNode head1, ListNode head2){
        ListNode curr = new ListNode();
        ListNode res = curr;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                curr.next = head1;
                curr = curr.next;
                head1 = head1.next;
            }else{
                curr.next = head2;
                curr = curr.next;
                head2 = head2.next;
            }
        }
        if(head1 != null){
            curr.next = head1;
        }
        if(head2 != null){
            curr.next = head2;
        }
        return res.next;
    }
}