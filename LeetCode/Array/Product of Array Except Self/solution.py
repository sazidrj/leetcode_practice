class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)

        if n <= 1:
            return [0]

        prefix_product = [1]*n
        suffix_product = [1]*n

        for i in range(n):
            if i == 0:
                prefix_product[i] = nums[i]
            else:
                prefix_product[i] = prefix_product[i-1]*nums[i]
        
        for i in range(n-1,0,-1):
            if i == n-1:
                suffix_product[i] = nums[i]
            else:
                suffix_product[i] = nums[i] * suffix_product[i+1]

        res = [0]*n
        
        for i in range(n):
            if i == 0:
                res[i] = suffix_product[i+1]
            elif i == n-1:
                res[i] = prefix_product[i-1]
            else:
                res[i] = prefix_product[i-1]*suffix_product[i+1]
        
        return res
        