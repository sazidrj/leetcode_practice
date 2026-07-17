class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        sz = len(intervals)
        
        if(sz <= 1):
            return intervals

        intervals.sort(key = lambda x: x[0])

        start = intervals[0][0]
        end = intervals[0][1]

        ans = []

        for i in range(1,sz):
            if(intervals[i][0] > end):
                ans.append([start, end])
                start = intervals[i][0]
                end = intervals[i][1]
            else:
                end = max(end, intervals[i][1])
        
        ans.append([start, end])

        return ans
        