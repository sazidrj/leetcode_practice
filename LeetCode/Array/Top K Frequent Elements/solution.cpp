class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        if(k == nums.size()){
            return nums;
        }

        unordered_map<int, int> count_map;
        for(int n: nums){
            count_map[n] += 1;
        }

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;

        for(auto [num, count]: count_map){
            pq.push({count, num});

            if(pq.size() > k){
                pq.pop();
            }
        } 

        vector<int> res;

        while(!pq.empty()){
            res.push_back(pq.top().second);
            pq.pop();
        }

        return res;
    }
};