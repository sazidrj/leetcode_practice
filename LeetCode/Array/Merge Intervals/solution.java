class Solution {
    public int[][] merge(int[][] intervals) {
        int sz = intervals.length;
        if(sz <= 1){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> ans = new ArrayList<>();

        for(int i = 1; i<sz; i++){
            if(intervals[i][0] > end){
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                end = Math.max(end, intervals[i][1]);
            }
        }

        ans.add(new int[]{start, end});

        return ans.toArray(new int[ans.size()][]);

        
    }
}