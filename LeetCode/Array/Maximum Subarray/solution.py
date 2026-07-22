class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = nums[0]
        maxi = nums[0]

        for i in range(1, len(nums)):
            maxi = max(nums[i], maxi + nums[i])
            res = max(res, maxi)

        return res
        