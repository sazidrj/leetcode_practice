class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0; i<n; i++){
            long sum = target - nums[i];

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i+1; j<n; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                long sum2 = sum - nums[j];

                int left = j+1, right = n-1;

                while(left < right){
                    long newSum = nums[left] + nums[right];

                    if(sum2 == newSum){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }else if(sum2  > newSum){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }

        return res;
    }
}