class Solution {
public:
  vector<int> topKFrequent(vector<int>& nums, int k) {
 vector<int> res;
 map<int,int> m;
 int n = nums.size();

 for(int i = 0; i<n; i++){
 	 m[nums[i]]++;
 }  

 vector<vector<int>> v(n+1);

 for(auto it : m){
 	int freq = it.second;
 	int elm = it.first;
   
 	v[freq].push_back(elm);
 }
  
 int count = 0, flag = 1;


 for(int i = n; i>=0; i--){
      if(v[i].size() > 0){
      	 for(auto x : v[i]){
      	 	 res.push_back(x);
             count++;

             if(count == k){
                 flag = 0;
                 break;
             }

      	 }         
      }

      if(flag == 0){
      	 break;
      }
   }

   return res;

 }
};