class Solution {

    // T: O(n^2*m) Time Limit Exceeded
    // S: O(1)

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isPalindrome(words[i] + words[j])) {
                    List<Integer> pair = new ArrayList();
                    pair.add(i);
                    pair.add(j);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}