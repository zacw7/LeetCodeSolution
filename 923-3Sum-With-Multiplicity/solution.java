class Solution {
    public int threeSumMulti(int[] A, int target) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Map<Integer, Integer> countMap = new HashMap();
        for (int n : A) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        Arrays.sort(A);

        long count = 0, MOD = 1000000007;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }
            int t = target - A[i];
            int left = i + 1, right = A.length - 1;
            while (left < right) {
                if (left > i + 1 && A[left] == A[left] - 1) {
                    left++;
                    continue;
                }
                if (right < A.length - 1 && A[right] == A[right + 1]) {
                    right--;
                    continue;
                }
                int sum = A[left] + A[right];
                if (sum == t) {
                    if (A[i] == A[right]) {
                        int c = countMap.get(A[i]);
                        count += (((c * (c - 1)) % MOD * (c - 2) / 6)) % MOD;
                    } else if (A[i] == A[left]) {
                        int c = countMap.get(A[i]);
                        count += (((c * (c - 1) / 2) % MOD * countMap.get(A[right]))) % MOD;
                    } else if (A[left] == A[right]) {
                        int c = countMap.get(A[right]);
                        count += (((c * (c - 1) / 2) % MOD * countMap.get(A[i]))) % MOD;
                    } else {
                        count += (countMap.get(A[i]) * countMap.get(A[left]) * countMap.get(A[right])) % MOD;
                    }
                    count %= MOD;
                    left++;
                    right--;
                } else if (sum < t) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return (int) count;
    }
}