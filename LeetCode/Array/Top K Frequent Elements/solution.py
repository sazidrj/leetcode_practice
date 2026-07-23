class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count_map = Counter(nums)

        pq = []

        for num, count in count_map.items():
            heapq.heappush(pq, (count, num))
            if len(pq) > k:
                heapq.heappop(pq)

        return [num for count, num in pq]
        