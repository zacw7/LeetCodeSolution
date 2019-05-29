class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList(arr.length);
        for (int num : arr) {
            list.add(num);
        }
        if (x <= arr[0]) {
            return list.subList(0, k);
        } else if (x >= arr[arr.length - 1]) {
            return list.subList(arr.length - k, arr.length);
        } else {
            int lo = 0, hi = arr.length - 1;
            while (lo + 1 < hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] == x) {
                    lo = hi = mid;
                    break;
                } else if (arr[mid] > x) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
            if (Math.abs(x - arr[lo]) <= Math.abs(x - arr[hi])) {
                hi = lo;
            } else {
                lo = hi;
            }
            while (hi - lo + 1 < k) {
                if (lo > 0 && hi + 1 < arr.length) {
                    if (Math.abs(x - arr[lo - 1]) <= Math.abs(x - arr[hi + 1])) {
                        lo--;
                    } else {
                        hi++;
                    }
                } else if (lo > 0) {
                    lo--;
                } else if (hi + 1 < arr.length) {
                    hi++;
                } else {
                    break;
                }
            }
            return list.subList(lo, hi + 1);
        }
    }
}