/**
 * 1. Problem:
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * 3. Constraints:
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
 *
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
     * Compare one by one
     *
     * 2.Complexity:
     * Time: O(k*N)
     * Space: O(n)
     */
    /
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();
        int k = lists.length;
        ListNode temp = res;
        int totalcount = k;
        while(totalcount > 0){
            int tempres = Integer.MAX_VALUE;
            int count = -1;
            for(int i = 0; i < k; i++){
                if(lists[i] != null && tempres > lists[i].val){
                    tempres = lists[i].val;
                    count = i;
                }
            }
            if(count < 0){
                break;
            }
            temp.next = new ListNode(tempres);
            temp = temp.next;

            lists[count] = lists[count].next;
            if(lists[count] == null){
                totalcount--;
            }
        }
        return res.next;
    }
}

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
     * 1.Approach:
     * This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly
     * Pair up k lists and merge each pair.
     * After the first pairing, k lists are merged into k/2 lists with average 2N/k length, then k/4, k/8 and so on.
     * Repeat this procedure until we get the final sorted linked list.
     * Thus, we'll traverse almost N nodes per pairing and merging, and repeat this procedure about log(k) times.
     *
     * 2.Complexity:
     * Time: O(N * log(k))
     * Space: O(1)
     */
    /
    public ListNode mergeKLists(ListNode[] lists) {
        int amount = lists.length;
        int interval = 1;
        while(interval < amount){
            for(int i = 0; i + interval < amount; i+=interval){
                lists[i] = mergeTwoList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return amount > 0 ? lists[0] : null;
    }
    private ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode res = new ListNode();
        ListNode temp = res;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
                temp = temp.next;
            }else{
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
                temp = temp.next;
            }
        }
        if(list1 != null){
            temp.next = list1;
        }
        if(list2 != null){
            temp.next = list2;
        }
        return res.next;
    }
}