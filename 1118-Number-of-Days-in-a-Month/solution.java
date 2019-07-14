class Solution {
    public int numberOfDays(int Y, int M) {
        switch (M) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;
            case 4:
            case 6:
            case 9:
            case 11: return 30;
            case 2:
                if ((Y % 100 == 0 && Y % 400 == 0) || (Y % 100 > 0 && Y % 4 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }
}