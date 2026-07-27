class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int sum = 0, n = nums.length;
        mp.put(0, 1);

        int ans = 0;

        for(int i = 0; i<n; i++){
            sum += nums[i];

            int remSum = sum - k;

            if(mp.containsKey(remSum)){
                ans += mp.get(remSum);
            }

            if(mp.containsKey(sum)){
                mp.put(sum, mp.get(sum) +1);
            }else{
                mp.put(sum , 1);
            }
        }

        return ans;
    }
}