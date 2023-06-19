class Solution {

    public int largestAltitude(int[] gain) {
        int currAlt = 0;
        int maxAlt = 0;
        for (int i = 0; i < gain.length; i++) {
            currAlt = currAlt + gain[i];
            if (currAlt > maxAlt) {
                maxAlt = currAlt;
            }
        }
        return maxAlt;
    }
}
