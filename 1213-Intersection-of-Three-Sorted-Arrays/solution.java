class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList();
        int p1 = 0, p2 = 0, p3 = 0;
        int max = Integer.MIN_VALUE;
        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            max = Math.max(arr1[p1], Math.max(arr2[p2], arr3[p3]));
            if (arr1[p1] == max && arr2[p2] == max && arr3[p3] == max) {
                res.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            } else {
                if (arr1[p1] < max) {
                    p1++;
                }
                if (arr2[p2] < max) {
                    p2++;
                }
                if (arr3[p3] < max) {
                    p3++;
                }
            }
        }
        return res;
    }
}