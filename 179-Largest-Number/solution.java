class Solution {
    // T: O(nlogn)
    // S: O(1)
    public String largestNumber(int[] nums) {
        String[] numstrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numstrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numstrs, new LargerNumberComparator());
        String ans = String.join("", numstrs).replaceFirst("^0+", "");
        return (ans.length() == 0) ? "0" : ans;
    }

    class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String a = s1 + s2;
            String b = s2 + s1;
            return b.compareTo(a);
        }
    }
}