class Solution {
    public int[] sortArrayByParityII(int[] A) {
        Queue<Integer> evenIndexes = new LinkedList();
        Queue<Integer> oddIndexes = new LinkedList();
        for (int i = 0; i < A.length; i++) {
            if ((i % 2) == (A[i] % 2)) continue;
            if (i % 2 == 0) {
                evenIndexes.add(i);
            } else {
                oddIndexes.add(i);
            }
        }
        while (!evenIndexes.isEmpty() && !oddIndexes.isEmpty()) {
            int even = evenIndexes.poll();
            int odd = oddIndexes.poll();
            int temp = A[even];
            A[even] = A[odd];
            A[odd] = temp;
        }
        return A;
    }
}