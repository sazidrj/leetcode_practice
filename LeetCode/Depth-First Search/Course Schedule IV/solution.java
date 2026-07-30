class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int[] pre: prerequisites){
            int a = pre[0];
            int b = pre[1];
            adjList.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        Map<Integer, Set<Integer>> nodePrerequisites = new HashMap<>();

        while(!q.isEmpty()){
            int node = q.poll();

            for(int nbr: adjList.getOrDefault(node, new ArrayList<>())){
                nodePrerequisites.computeIfAbsent(nbr, k -> new HashSet<>()).add(node);
                for(int prereq: nodePrerequisites.getOrDefault(node, new HashSet<>())){
                    nodePrerequisites.get(nbr).add(prereq);
                }

                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] query: queries){
            ans.add(nodePrerequisites.getOrDefault(query[1], new HashSet<>()).contains(query[0]));
        }

        return ans;
        
    }
}