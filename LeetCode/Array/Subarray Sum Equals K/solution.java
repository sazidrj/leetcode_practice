class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap();
        mp.put(0, 1);

        int ans = 0;
        int sum = 0;
        int remSum = 0;

        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            remSum = sum - k;

            if(mp.containsKey(remSum)){
                ans += mp.get(remSum);
            }
            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }

        return ans;
        
    }
}