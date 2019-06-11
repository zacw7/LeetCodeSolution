class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (i + 1 < chs.length && map.get(chs[i]) < map.get(chs[i + 1])) {
                num -= map.get(chs[i]);
            } else {
                num += map.get(chs[i]);
            }
        }
        return num;
    }
}