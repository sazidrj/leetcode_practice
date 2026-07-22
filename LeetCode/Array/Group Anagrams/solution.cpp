class Solution {
public:
    string helper(string str){
        vector<int> freq(26, 0);

        for(char ch: str){
            freq[ch-'a']++;
        }

        string res = "";

        for(int i=0; i<26; i++){
            res += string(freq[i], i+'a');
        }

        return res;
    }

    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int n = strs.size();
        vector<vector<string>> res;
        unordered_map<string, vector<string>> mp;

        for(auto str: strs){
            mp[helper(str)].push_back(str);
        }

        for(auto m: mp){
            res.push_back(m.second);
        }

        return res;
    }
};