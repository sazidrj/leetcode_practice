class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList();
        for(int i = 0; i<numCourses; i++){
            g.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int i = 0; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            g.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList();
        List<Integer> v = new ArrayList();

        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int f = q.poll();
            v.add(f);
            for(int neighbor : g.get(f)){
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if(v.size() == numCourses)
            return v.stream().mapToInt(Integer::intValue).toArray();
        else
            return new int[0];
    
    }
}