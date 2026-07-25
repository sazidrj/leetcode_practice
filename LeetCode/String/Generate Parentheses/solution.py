class Solution:
    def solve(self, cur:string, open:int, close:int, res:List[str]):
        if open == 0 and close == 0:
            res.append(cur)
            return
        
        if open > 0:
            self.solve(cur + '(', open-1, close+1, res)
        
        if close>0:
            self.solve(cur + ')', open, close-1, res)

        return res
        
    def generateParenthesis(self, n: int) -> List[str]:
        open = n
        close = 0
        cur = ""
        res = []
        self.solve(cur, open, close, res)

        return res
        