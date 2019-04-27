/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int r1 = rand7(), r2 = rand7();
        while (r1 == 7) {
            r1 = rand7();
        }
        r1 %= 2;

        while (r2 > 5) {
            r2 = rand7();
        }

        return r1 * 5 + r2;
    }
}