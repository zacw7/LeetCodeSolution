/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        int N = wordlist.length;
        int[][] S = new int[N][N];
        List<Integer> resultList = new ArrayList();
        for (int i = 0; i < N; i++) {
            resultList.add(i);
            for (int j = i + 1; j < N; j++) {
                S[i][j] = S[j][i] = getSimilarity(wordlist[i], wordlist[j]);
            }
        }
        while (resultList.size() > 0) {
            int tryWord = findNextTry(resultList, S);
            int match = master.guess(wordlist[tryWord]);
            if (match == 6) {
                return;
            }
            List<Integer> tmp = new ArrayList();
            for (int w : resultList) {
                if (w != tryWord && S[w][tryWord] == match) {
                    tmp.add(w);
                }
            }
            resultList = tmp;
        }
    }

    private int findNextTry(List<Integer> resultList, int[][] S) {
        if (resultList.size() == 2) {
            return resultList.get(0);
        }
        int minUnmatch = Integer.MAX_VALUE, select = -1;
        for (int w1 : resultList) {
            int unmatch = 0;
            for (int w2 : resultList) {
                if (w1 != w2 && S[w1][w2] == 0) {
                    unmatch++;
                }
            }
            if (unmatch < minUnmatch) {
                minUnmatch = unmatch;
                select = w1;
            }
        }
        return select;
    }

    private int getSimilarity(String A, String B) {
        int sim = 0;
        for (int i = 0; i < 6; i++) {
            if (A.charAt(i) == B.charAt(i)) {
                sim++;
            }
        }
        return sim;
    }
}