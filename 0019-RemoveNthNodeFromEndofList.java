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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = head;
        ListNode b = head;
        for(int i = n; i > 0; i--){
            if(a.next == null){
                head = head.next;
                return head;
            }else{
                a = a.next;
            }
        }
        while(a.next != null){
            a = a.next;
            b = b.next;
        }
        if(b.next.next != null){
            b.next = b.next.next;
        }else{
            b.next = null;
        }
        return head;
    }
}