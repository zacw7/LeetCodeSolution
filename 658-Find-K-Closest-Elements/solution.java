class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList(k);
        if (arr == null || arr.length == 0 || k == 0) {
            return ans;
        }
        int lo = 0, hi = arr.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) {
                lo = mid;
                hi = mid + 1;
                break;
            } else if (arr[mid] > x) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        while (k-- > 0) {
            if (lo >= 0 && hi < arr.length) {
                if (x - arr[lo] <= arr[hi] - x) {
                    ans.add(arr[lo--]);
                } else {
                    ans.add(arr[hi++]);
                }
            } else if (lo >= 0) {
                ans.add(arr[lo--]);
            } else if (hi < arr.length) {
                ans.add(arr[hi++]);
            } else {
                break;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}