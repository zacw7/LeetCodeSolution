class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for (int b : bills) {
            switch (b) {
                case 5: fives++; break;
                case 10:
                    if (fives == 0) return false;
                    fives--;
                    tens++;
                    break;
                case 20:
                    if (tens > 0) {
                        b -= 10;
                        tens--;
                    }
                    int needs = (b - 5) / 5;
                    if (fives < needs) return false;
                    fives -= needs;
                    break;
            }
        }
        return true;
    }
}