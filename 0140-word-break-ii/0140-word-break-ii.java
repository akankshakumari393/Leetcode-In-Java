/*
https://leetcode.com/problems/word-break-ii/solutions/2626965/c-backtracking-solution-with-proof-of-time-complexity/
*/

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentences = new ArrayList<>();
        word(0, s, wordDict, new ArrayList<>(), sentences);
        return sentences;
    }

    public void word(int index, String s, List<String> wordDict, List<String> curr, List<String> sentences) {
        if (index == s.length()) {
            sentences.add(String.join(" ", curr));
            return;
        }

        for (int j = index; j < s.length(); j++) {
            String word = s.substring(index, j + 1);
            // if substring from index..j is in list then proceed
            if (wordDict.contains(word)) {
                curr.add(word);
                word(j + 1, s, wordDict, curr, sentences);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
