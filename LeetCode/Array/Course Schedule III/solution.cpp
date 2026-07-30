class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        sort(courses.begin(), courses.end(), [](const vector<int> &a, const vector<int> &b){
            if (a[1] == b[1]){
                return a[0] < b[0];
            }
            return a[1] < b[1];
        });
        priority_queue<int> pq;

        int time = 0;

        for(int i = 0; i<courses.size(); i++){
            int duration = courses[i][0];
            int lastDay = courses[i][1];

            if (duration <= lastDay){
                if(time + duration <= lastDay){
                    time += duration;
                    pq.push(duration);
                }else{
                    if(pq.top() > duration){
                        time -= pq.top();
                        time += duration;
                        pq.pop();
                        pq.push(duration);
                    }
                }
            }
        }

        return pq.size();
        
    }
};