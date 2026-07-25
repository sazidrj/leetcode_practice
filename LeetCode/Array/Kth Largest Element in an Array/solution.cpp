class Solution {
public:
    int partition(vector<int> &nums, int left, int right, int pivot_index){
        int pivot = nums[pivot_index];
        int i = left;
        int j = right;

        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;

            if (i <= j) {
                swap(nums[i], nums[j]);
                i++;
                j--;
            }
        }
        return i; // Split index
    }

    int quickselect(vector<int> &nums, int left, int right, int k) {
        // Base case: range collapsed to 1 element
        if (left >= right) {
            return nums[left];
        }

        int pivot_index = left + rand() % (right - left + 1);

        int split = partition(nums, left, right, pivot_index);

        // Recurse into the appropriate half
        if (k < split) {
            return quickselect(nums, left, split - 1, k);
        } else {
            return quickselect(nums, split, right, k); // Fix: range starts at 'split', not 'split + 1'
        }
    }

    int findKthLargest(vector<int>& nums, int k) {
        int left = 0;
        int right = nums.size() - 1;

        return quickselect(nums, left, right, nums.size() - k);
    }
};