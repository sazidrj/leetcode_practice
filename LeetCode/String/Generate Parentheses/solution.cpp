class Solution {
public:
    void solve(string cur, int open,  int close, vector<string> &res){
        if(open == 0 and close == 0) {
            res.push_back(cur);
            return;
        }
        
        if(open > 0){
            solve(cur + '(', open-1, close+1, res);
        }

        if(close > 0){
            solve(cur + ')', open, close-1, res);
        } 
    }

    vector<string> generateParenthesis(int n) {
        string cur = "";
        vector<string> res;
        int open = n, close = 0;

        solve(cur, open, close, res);

        return res;


    }
};