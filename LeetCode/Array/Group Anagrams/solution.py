class Solution:
    def solve(self, stri: str) -> str:
        freq = [0] * 26

        for ch in stri:
            freq[ord(ch) - ord('a')] += 1
        
        res = ""
        
        for i in range(26):
            res += chr(i + ord('a')) * freq[i]
        
        return res


    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        n = len(strs)
        res = []

        hm = {}

        for str in strs:
            key = self.solve(str)
            
            if key not in hm:
                hm[key] = []

            hm[key].append(str)

        for key, val in hm.items():
            res.append(val)

        return res
        