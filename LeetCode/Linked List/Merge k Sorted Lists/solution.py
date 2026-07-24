# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        dummyNode = ListNode(0)
        it = dummyNode

        for i, lst in enumerate(lists):
            if lst:
                heapq.heappush(heap, (lst.val, i, lst))
        
        while heap:
            val, i, lst = heapq.heappop(heap)
            it.next = lst
            it = it.next
            if lst.next:
                heapq.heappush(heap,(lst.next.val, i, lst.next))
        
        return dummyNode.next


        

        