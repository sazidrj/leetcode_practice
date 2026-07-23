class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        if( k == n){
            return nums;
        }

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            pq.offer(new int[]{entry.getValue(), entry.getKey()});

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        int index = 0;

        while(!pq.isEmpty()){
            res[index++] = pq.poll()[1];
        }

        return res;
    }
}