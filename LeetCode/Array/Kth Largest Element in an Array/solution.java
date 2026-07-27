class Solution {
    public int partition(int[] nums, int left, int right, int pivot_index){
        int pivot = nums[pivot_index];
        int i = left;
        int j = right;

        while(i<=j){
            while(nums[i] < pivot){
                i++;
            }
            while(nums[j] > pivot){
                j--;
            }

            if(i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    public int quickselect(int[] nums, int left, int right, int k){
        if(left >= right) return nums[left];

        Random rand = new Random();
        int pivot_index = left + rand.nextInt(right - left + 1);
        int split = partition(nums, left, right, pivot_index);

        if(k < split){
            return quickselect(nums, left, split-1, k);
        }else{
            return quickselect(nums, split, right, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        return quickselect(nums, left, right, n-k);
    }
}