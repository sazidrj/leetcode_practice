class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0]*numCourses

        g = [[] for _ in range(numCourses)]

        for elm in prerequisites:
            a = elm[0]
            b = elm[1]
            g[a].append(b)
            indegree[b] += 1
        
        v = []
        q = []

        for i in range(numCourses):
            if indegree[i] == 0:
                heapq.heappush(q, i)
                v.append(i)
        
        while q:
            f = heapq.heappop(q)

            for x in g[f]:
                indegree[x] -= 1

                if indegree[x] == 0:
                    heapq.heappush(q,x)
                    v.append(x)
        
        if len(v) == numCourses:
            return True
        else:
            return False
        