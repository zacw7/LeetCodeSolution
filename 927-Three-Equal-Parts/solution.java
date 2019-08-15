class Solution {
    public int[] threeEqualParts(int[] A) {
        int count = 0;
        for (int n : A) {
            count += n;
        }
        if (count == 0) {
            return new int[]{0, A.length - 1};
        }
        if (count % 3 > 0) {
            return new int[]{-1, -1};
        }
        int each = count / 3;
        int idx1 = -1, idx2 = -1, idx3 = -1;
        for (int cnt = 0, i = 0; i < A.length; i++) {
            cnt += A[i];
            if (cnt == 1) {
                if (idx1 == -1) idx1 = i;
            } else if (cnt == each + 1) {
                if (idx2 == -1) idx2 = i;
            } else if (cnt == each * 2 + 1) {
                idx3 = i;
                break;
            }
        }
        int shift = 1;
        while (idx3 + shift < A.length) {
            if (idx1 + shift >= idx2
                    || idx2 + shift >= idx3
                    || A[idx1 + shift] != A[idx2 + shift]
                    || A[idx2 + shift] != A[idx3 + shift]) {
                return new int[]{-1, -1};
            }
            shift++;
        }
        return new int[]{idx1 + shift - 1, idx2 + shift};
    }
}