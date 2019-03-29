class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Map<Integer, Queue<Integer>> map = new HashMap();
        Queue<Integer> unassigned = new LinkedList();
        int[] originB = B.clone();
        Arrays.sort(A);
        Arrays.sort(B);
        int pntA = 0, pntB = 0;
        while (pntA < A.length && pntB < B.length) {
            if (A[pntA] > B[pntB]) {
                Queue<Integer> queue = map.getOrDefault(B[pntB], new LinkedList());
                queue.add(A[pntA]);
                map.put(B[pntB], queue);
                pntB++;
            } else {
                unassigned.add(A[pntA]);
            }
            pntA++;
        }
        while (pntB < B.length) {
            Queue<Integer> queue = map.getOrDefault(B[pntB], new LinkedList());
            queue.add(unassigned.poll());
            map.put(B[pntB], queue);
            pntB++;
        }
        for (int i = 0; i < originB.length; i++) {
            Queue<Integer> queue = map.get(originB[i]);
            A[i] = queue.poll();
        }
        return A;
    }
}