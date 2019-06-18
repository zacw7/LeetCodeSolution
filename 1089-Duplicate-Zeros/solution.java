class Solution {
    public void duplicateZeros(int[] arr) {
        int[] tmp = arr.clone();
        int i = 0, j = 0;
        while (i < arr.length && j < tmp.length) {
            if (tmp[j] == 0) {
                arr[i++] = 0;
                if (i >= arr.length) {
                    break;
                }
                arr[i++] = 0;
                j++;
            } else {
                arr[i++] = tmp[j++];
            }
        }
    }
}