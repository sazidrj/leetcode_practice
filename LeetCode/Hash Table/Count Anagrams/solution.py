mod = 10**9 + 7
class Solution:
    fact = [1]*100002

    def modmul(self, a:int, b:int) -> int:
        return ((a%mod) * (b%mod)) % mod
    
    def binExpo(self, a:int, b:int) -> int:
        if not b:
            return 1
        res = self.binExpo(a, b//2)

        if b & 1:
            return self.modmul(a, self.modmul(res, res))
        else:
            return self.modmul(res, res)
    
    def modmulinv(self, a:int) -> int:
        return self.binExpo(a, mod-2)
    
    def getfact(self):
        self.fact[0] = 1
        for i in range(1, 100002):
            self.fact[i] = self.modmul(self.fact[i-1], i)
        
    def ways(self, stri:str):
        freq = [0]*26

        for ch in stri:
            freq[ord(ch) - ord('a')] += 1
        
        totalWays = self.fact[len(stri)]
        factR = 1

        for i in range(26):
            factR = self.modmul(factR, self.fact[freq[i]])
        
        return self.modmul(totalWays, self.modmulinv(factR))

    def countAnagrams(self, s: str) -> int:
        self.getfact()
        strArr = s.split()
        ans = 1

        for i in range(len(strArr)):
            ans = self.modmul(ans, self.ways(strArr[i]))
        
        return ans

