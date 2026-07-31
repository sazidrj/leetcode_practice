class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        indegree = [0]*numCourses
        adjList = defaultdict(list)

        for edge in prerequisites:
            adjList[edge[0]].append(edge[1])
            indegree[edge[1]] += 1
        
        q = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
        
        nodePrerequisites = defaultdict(set)
        
        while q:
            node = q.popleft()

            for nbr in adjList[node]:
                nodePrerequisites[nbr].add(node)

                for prereq in nodePrerequisites[node]:
                    nodePrerequisites[nbr].add(prereq)
                
                indegree[nbr] -= 1
                if indegree[nbr] == 0:
                    q.append(nbr)
        
        ans = []

        for q in queries:
            ans.append(q[0] in nodePrerequisites[q[1]])

        return ans

        
        