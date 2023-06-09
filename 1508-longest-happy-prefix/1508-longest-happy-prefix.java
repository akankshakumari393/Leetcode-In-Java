class Solution {
    public String longestPrefix(String s) {
        int k = longestPrefixSuffix(s);
        return s.substring(0,k);
    }

    public int longestPrefixSuffix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        for (int i = 1; i < n; i++) {
            while (s.charAt(i) != s.charAt(len) && len > 0) {
                len = lps[len-1];
            }
            if (s.charAt(i) == s.charAt(len)) {
                lps[i] = len+1;
                len++;
            }
        }
        return lps[n-1];
    }
}