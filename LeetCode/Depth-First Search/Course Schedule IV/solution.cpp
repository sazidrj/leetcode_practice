class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        vector<int> indegree(numCourses, 0);
        unordered_map<int, vector<int>> adjList;

        for(auto pre: prerequisites){
            int a = pre[0];
            int b = pre[1];
            adjList[a].push_back(b);
            indegree[b]++;
        }

        queue<int> q;

        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.push(i);
            }
        }

        unordered_map<int, unordered_set<int>> nodePrerequisites;

        while(!q.empty()){
            int node = q.front();
            q.pop();

            for(auto nbr: adjList[node]){
                nodePrerequisites[nbr].insert(node);
                for(auto prereq: nodePrerequisites[node]){
                    nodePrerequisites[nbr].insert(prereq);
                }
                indegree[nbr]--;

                if(indegree[nbr] == 0){
                    q.push(nbr);
                }
            }
        }

        vector<bool> ans;
        for(auto q: queries){
            ans.push_back(nodePrerequisites[q[1]].contains(q[0]));
        }

        return ans;
        
    }
};