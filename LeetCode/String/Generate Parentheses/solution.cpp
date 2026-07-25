class Solution {
public:
 void helper(string s, int left, int right, vector<string>& ans){
     if(left == 0 and right == 0)
        {
          ans.push_back(s);
          return;
        }

     if(left > 0){
          helper(s + "(", left-1, right+1, ans);
     }

     if(right > 0){
         helper(s+")", left, right-1, ans);
     }
}


vector<string> generateParenthesis(int n) {
     string s = "";
     int left = n, right = 0;

     vector<string> ans;

     helper(s,left,right,ans);

     return ans;          
}
};