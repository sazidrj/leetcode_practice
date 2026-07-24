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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.val, b.val);
        });
        ListNode dummyNode = new ListNode(0);
        ListNode it = dummyNode;

        for(int i = 0; i<lists.length; i++){
            if(lists[i] != null)
                pq.offer(lists[i]);
        }

        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();

            it.next = minNode;
            it = it.next;

            if(minNode.next != null){
                pq.offer(minNode.next);
            }
        }

        return dummyNode.next;
        
    }
}