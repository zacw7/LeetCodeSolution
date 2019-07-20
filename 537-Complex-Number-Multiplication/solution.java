class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] fac1 = getFactors(a);
        int[] fac2 = getFactors(b);
        int[] ans = new int[]{fac1[0] * fac2[0] - fac1[1] * fac2[1], fac1[0] * fac2[1] + fac2[0] * fac1[1]};
        return ans[0] + "+" + ans[1] + "i";
    }

    private int[] getFactors(String s) {
        int i = s.indexOf("+");
        return new int[]{Integer.valueOf(s.substring(0, i)), Integer.valueOf(s.substring(i + 1, s.length() - 1))};
    }
}