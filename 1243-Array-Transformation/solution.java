class Solution {
    public List<Integer> transformArray(int[] arr) {
        int N = arr.length;
        boolean changed = true;
        while (changed) {
            changed = false;
            int[] tmp = arr.clone();
            for (int i = 1; i < N - 1; i++) {
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    changed = true;
                    tmp[i]++;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    changed = true;
                    tmp[i]--;
                }
            }
            arr = tmp;
        }
        List<Integer> res = new ArrayList();
        for (int n : arr) {
            res.add(n);
        }
        return res;
    }
}