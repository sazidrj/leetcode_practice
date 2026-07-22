class Solution {
    public String helper(String str){
        int[] freq = new int[26];
        Arrays.fill(freq, 0);

        for(int i = 0; i<str.length(); i++){
            freq[str.charAt(i) - 'a']++;
        }

        StringBuilder res = new StringBuilder();

        for(int i=0; i<26; i++){
            for(int j = 0; j<freq[i]; j++){
                res.append((char)('a'+i));
            }           
        }

        return res.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            String key = helper(strs[i]);

            if (!hm.containsKey(key)){
                hm.put(key, new ArrayList<>());
            }

            hm.get(key).add(strs[i]);
        }

        hm.forEach((key, val) -> {
            res.add(val);
        });

    
        return res;
    }
}