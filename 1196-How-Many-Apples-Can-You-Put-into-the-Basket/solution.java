class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int count = 0, remain = 5000;
        for (int a : arr) {
            if (remain < a) {
                break;
            } else {
                count++;
                remain -= a;
            }
        }
        return count;
    }
}