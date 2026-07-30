class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        courses.sort(key = lambda x: (x[1], x[0]))

        max_heap = []
        time = 0

        for course in courses:
            duration = course[0]
            lastday = course[1]
            
            if duration <= lastday:
                if time + duration <= lastday:
                    heapq.heappush(max_heap, -duration)
                    time += duration
                else:
                    if max_heap and -max_heap[0] > duration:
                        time += heapq.heappop(max_heap)
                        time += duration
                        heapq.heappush(max_heap, -duration)
        
        return len(max_heap)
        