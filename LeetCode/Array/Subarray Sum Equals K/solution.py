class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        mp = {}
        ans = 0
        sum = 0
        mp[0] = 1

        for i in range(len(nums)):
            sum += nums[i]
            remSum = sum - k

            if remSum in mp:
                ans += mp[remSum]
            
            if sum in mp:
                mp[sum] = mp[sum] + 1
            else:
                mp[sum] = 1
        
        return ans