class Solution {
    public int minDeletionSize(String[] A) {
        int count = 0;
        for (int i = 0; i < A[0].length(); i++) {
            char ch = A[0].charAt(i);
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) >= ch) {
                    ch = A[j].charAt(i);
                } else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}