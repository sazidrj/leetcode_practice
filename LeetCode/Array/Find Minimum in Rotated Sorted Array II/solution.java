class Solution {
    public int findMin(int[] nums) {
         int ans = Integer.MAX_VALUE;

         int i = 0, j = nums.length-1;

         while(i <= j){
             int mid = (i + j)/2;

            if(nums[i] == nums[mid] && nums[j] == nums[mid]){
                i++;
                j--;
            }
             else if(nums[mid]<=nums[j])
                 j = mid-1;
             else if(nums[mid] > nums[j])
                 i = mid+1;

             if(nums[mid] < ans){
                 ans = nums[mid];
             }


         }
         return ans;
    }

}