class Solution {
    static final int MOD = 1_000_000_007;
    int fact[] = new int[100002];

    public Solution() {
        Arrays.fill(fact, 1);
    }
   
    int modmul(int a, int b){
        return (int)(((long)(a%MOD)*(b%MOD))%MOD);
    }

    int binExpo(int a, int b){
        if (b <= 0){
            return 1;
        }

        int res = binExpo(a, b/2);

        if ((b&1) > 0){
            return modmul(a, modmul(res, res));
        }else{
            return modmul(res, res);
        }
    }

    int modmulinv(int a){
        return binExpo(a, MOD-2);
    }

    void getfact(){
        fact[0] = 1;

        for(int i = 1; i<=100001; i++){
            fact[i] = modmul(fact[i-1], i);
        }
    }

    int ways(String str){
        int freq[] = new int[26];
        Arrays.fill(freq, 0);

        for(int i = 0; i<str.length(); i++){
            freq[str.charAt(i) - 'a']++;
        }

        int totalWays = fact[str.length()];
        int factR = 1;

        for(int i=0; i<26; i++){
            factR = modmul(factR, fact[freq[i]]);
        }
        return modmul(totalWays, modmulinv(factR));
    }

    public int countAnagrams(String s) {
        getfact();
        String[] strArr = s.split(" ");

        int ans = 1; 

        for(int i=0 ; i<strArr.length; i++){
            ans = modmul(ans, ways(strArr[i]));
        }

        return ans;
    }
}