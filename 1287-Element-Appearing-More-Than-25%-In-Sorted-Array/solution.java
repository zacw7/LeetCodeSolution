class Solution {
    public int findSpecialInteger(int[] arr) {
        int num = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                num = arr[i];
                count = 1;
            } else {
                count++;
            }
            if (count > arr.length / 4) {
                break;
            }
        }
        return num;
    }
}