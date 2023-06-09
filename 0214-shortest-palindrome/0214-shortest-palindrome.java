class Solution {

    public String shortestPalindrome(String s) {
        StringBuilder revStr = new StringBuilder(s);
        revStr.reverse();
        String str2 = new String(revStr);
        int k = longestPrefixSuffix(s + "$" + str2);
        StringBuilder tobeappended = new StringBuilder(s.substring(k));
        return tobeappended.reverse().toString()+s; 
    }

    public int longestPrefixSuffix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        for (int i = 1; i < n; i++) {
            while (s.charAt(i) != s.charAt(len) && len > 0) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) {
                lps[i] = len + 1;
                len++;
            }
        }
        return lps[n - 1];
    }
}
