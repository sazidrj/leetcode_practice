class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)

        res = nums[0]
        curSum = nums[0]

        for i in range(1,n):
           curSum = max(nums[i], curSum + nums[i])
           res = max(res, curSum)

        return res
        