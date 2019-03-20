class Solution {
    public List<Integer> pancakeSort(int[] A) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int index = A.length - 1; // last unsorted Index
        List<Integer> ans = new ArrayList();
        while (index > 0) {
            if (sortedA[index] == A[index]) {
                index--;
                continue;
            }
            // find the index of max number
            int maxIdx = 0;
            while (A[maxIdx] != sortedA[index]) maxIdx++;
            if (maxIdx > 0) {
                for (int left = 0, right = maxIdx; left < right; left++, right--) {
                    int tmp = A[left];
                    A[left] = A[right];
                    A[right] = tmp;
                }
                ans.add(maxIdx + 1);
            }
            ans.add(index + 1);
            for (int left = 0, right = index; left < right; left++, right--) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
            }
            index--;
        }
        return ans;
    }
}