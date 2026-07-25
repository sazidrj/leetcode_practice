class Solution {
    public void solve(String cur, int open, int close, List<String> res){
        if(open == 0 && close == 0){
            res.add(cur);
            return;
        }

        if(open > 0){
            solve(cur + '(', open-1, close+1, res);
        }
        if(close > 0){
            solve(cur + ')', open, close-1, res);
        }

        return;
    }

    public List<String> generateParenthesis(int n) {
        int open = n, close = 0;
        List<String> res = new ArrayList();
        String cur = "";
        
        solve(cur, open, close, res);

        return res;
    }
}