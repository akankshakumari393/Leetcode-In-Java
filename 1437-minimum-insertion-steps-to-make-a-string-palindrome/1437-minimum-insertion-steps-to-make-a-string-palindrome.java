class Solution {
    public int minInsertions(String s) {
        StringBuilder revStr = new StringBuilder(s);
        revStr.reverse();
        String str2 = new String(revStr);
        int k = longestCommonSubsequence(s, str2);
        return s.length() - k;
    }

    public int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] lcs = new int[m+1][n+1];

        for(int i=0; i<=m; i++ ) {
            lcs[i][0] = 0;
        }

        for(int j=0; j<=n; j++ ) {
            lcs[0][j] = 0;
        }
        for(int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }
        return lcs[m][n];
    }
    public int longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] lcs = new int[m+1][n+1];

        for(int i=0; i<=m; i++ ) {
            lcs[i][0] = 0;
        }

        for(int j=0; j<=n; j++ ) {
            lcs[0][j] = 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                } else {
                    lcs[i][j] = 0;
                }
                if (max < lcs[i][j]) {
                    max = lcs[i][j];
                }
            }
        }
        return max;
    }
}