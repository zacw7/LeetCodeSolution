/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    // T: O(n^2)
    // S: O(n)
    public int findCelebrity(int n) {
        int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (knows(j, i)) {
                    k[j]--;
                    k[i]++;
                } else {
                    k[i]--;
                }
            }
        }
        System.out.println(Arrays.toString(k));
        for (int i = 0; i < n; i++) {
            if (k[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}