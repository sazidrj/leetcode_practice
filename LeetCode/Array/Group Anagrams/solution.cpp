class Solution {
public:
    string countingSort(string s){
  int freq[26] = {0};
  for(char c : s){
       freq[c-'a']++;
  }

  string str;

  for(int i = 0; i<26; i++){
    str += string(freq[i], i+'a');
  }
  return str;
}

vector<vector<string>> groupAnagrams(vector<string> &strs)
{
   unordered_map<string, vector<string>> mapAnagrams;

   for(string s : strs){
      mapAnagrams[countingSort(s)].push_back(s);
   }

   vector<vector<string>> ans;

   for(auto m : mapAnagrams){
       ans.push_back(m.second);
   }

   return ans;
}
};