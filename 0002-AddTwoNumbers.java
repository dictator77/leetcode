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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int temp = 0;
        ListNode tempNode = result;
        ListNode templ1 = l1;
        ListNode templ2 = l2;
        while(templ1 != null && templ2 != null){
            tempNode.val = (templ1.val + templ2.val + temp) % 10;
            temp = (templ1.val + templ2.val + temp) / 10;
            if(templ1.next != null || templ2.next != null){
                tempNode.next = new ListNode();
                tempNode = tempNode.next;
            }
            templ1 = templ1.next;
            templ2 = templ2.next;
        }
        while(templ1 != null){
            tempNode.val = (templ1.val + temp) % 10;
            temp = (templ1.val + temp) / 10;
            if(templ1.next != null){
                tempNode.next = new ListNode();
                tempNode = tempNode.next;
            }
            templ1 = templ1.next;
        }
        while(templ2 != null){
            tempNode.val = (templ2.val + temp) % 10;
            temp = (templ2.val + temp) / 10;
            if(templ2.next != null){
                tempNode.next = new ListNode();
                tempNode = tempNode.next;
            }
            templ2 = templ2.next;
        }
        if(temp != 0){
            tempNode.next = new ListNode(temp);
        }
        return result;
    }
}