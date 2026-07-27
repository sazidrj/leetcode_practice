class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0]*numCourses

        g = [[] for _ in range(numCourses)]

        for elm in prerequisites:
            a = elm[0]
            b = elm[1]
            g[b].append(a)
            indegree[a] += 1
        
        v = []
        q = deque([])

        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
                v.append(i)
        
        while q:
            f = q.popleft()

            for x in g[f]:
                indegree[x] -= 1

                if indegree[x] == 0:
                    q.append(x)
                    v.append(x)
        
        if len(v) == numCourses:
            return True
        else:
            return False
        