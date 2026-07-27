class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
    int* indegree = new int[numCourses]{0};

    vector<int> g[numCourses];


    for(auto x: prerequisites){
          int a = x[0], b = x[1];
          g[a].push_back(b);
          indegree[b]++;
    }


    vector<int> v;

    queue<int> q;

    for(int i = 0; i<numCourses; i++){
    	if(indegree[i] == 0){
            q.push(i);
            v.push_back(i);
    	}
    }

    while(q.size()){
    	int f = q.front();
    	q.pop();

    	for(auto x : g[f]){
    		indegree[x]--;

    		if(indegree[x] == 0){
    			q.push(x);
    			v.push_back(x);
    		}
    	}
    }


    if(v.size() == numCourses){
    	return true;
    }else{
    	return false;
    }

    

}

};