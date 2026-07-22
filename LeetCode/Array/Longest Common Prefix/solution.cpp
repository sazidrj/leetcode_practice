class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.size() == 0){
            return "";
        }
        if(strs.size() == 1){
            return strs[0];
        }

        return longestCommonPrefix(strs, 0, strs.size()-1);
    }

    string longestCommonPrefix(vector<string> &strs, int l, int r){
        if(l == r){
            return strs[l];
        }
        
        int mid = (l + r)/ 2;

        string left = longestCommonPrefix(strs, l, mid);
        string right = longestCommonPrefix(strs, mid+1, r);
        string ans = commonPrefix(left, right);

        return ans;
    }

    string commonPrefix(string &left, string &right){
        
        int n1 = left.size();
        int n2 = right.size();
        string ans = "";
        for(int i = 0; i<min(n1, n2); i++){
            if(left[i] != right[i]){
                return left.substr(0, i);
            }
        }

        return left.substr(0, min(n1, n2));
    }
};