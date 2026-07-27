class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> mp;
        mp[0] = 1;

        int sum = 0;
        int remSum = 0;
        int ans = 0;

        for(int i = 0; i<nums.size(); i++){
            sum += nums[i];
            remSum = sum - k;

            if(mp.find(remSum) != mp.end()){
                ans += mp[remSum];
            }
            if(mp.find(sum) != mp.end()){
                mp[sum] = mp[sum] + 1;
            }else{
                mp[sum] = 1;
            }  
        }
        return ans;

    }
};