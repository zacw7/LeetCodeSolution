class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "NaN";
        }
        if (numerator == 0) {
            return "0";
        }
        long n1 = numerator;
        long n2 = denominator;
        n1 = Math.abs(n1);
        n2 = Math.abs(n2);
        StringBuilder sb = new StringBuilder();
        if (numerator > 0 != denominator > 0) {
            sb.append("-");
        }
        sb.append(n1 / n2);
        if (n1 % n2 == 0) {
            return sb.toString();
        }
        sb.append(".");
        n1 %= n2;
        Map<Long, Integer> digitsMap = new HashMap();
        digitsMap.put(n1, sb.length());
        while (n1 > 0) {
            n1 *= 10;
            long digit = n1 / n2;
            n1 %= n2;
            sb.append(digit);
            if (digitsMap.containsKey(n1)) {
                sb.insert(digitsMap.get(n1), "(");
                sb.append(")");
                break;
            } else {
                digitsMap.put(n1, sb.length());
            }
        }
        return sb.toString();
    }
}