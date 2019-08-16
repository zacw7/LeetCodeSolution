class Solution {
    public String countOfAtoms(String formula) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> atomCount = countAtoms(formula);
        for (Map.Entry<String, Integer> entry : atomCount.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }

    private Map<String, Integer> countAtoms(String formula) {
        Map<String, Integer> atomCount = new TreeMap();
        int i = 0;
        while (i < formula.length()) {
            char c = formula.charAt(i);
            int j = i + 1;
            if (c >= 'A' && c <= 'Z') {
                // extract the atom name
                while (j < formula.length() && formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z') {
                    j++;
                }
                String atom = formula.substring(i, j);
                // extract the number
                int num = 0;
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    num *= 10;
                    num += formula.charAt(j) - '0';
                    j++;
                }
                if (num == 0) {
                    num = 1;
                }
                // add to result
                atomCount.put(atom, atomCount.getOrDefault(atom, 0) + num);
            } else if (c == '(') {
                int open = 1;
                // extract the sub-formula count
                while (j < formula.length() && open > 0) {
                    if (formula.charAt(j) == '(') {
                        open++;
                    } else if (formula.charAt(j) == ')') {
                        open--;
                    }
                    j++;
                }
                Map<String, Integer> tmp = countAtoms(formula.substring(i + 1, j - 1));
                // extract the number
                int num = 0;
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    num *= 10;
                    num += formula.charAt(j) - '0';
                    j++;
                }
                if (num == 0) {
                    num = 1;
                }
                // add to result
                for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
                    atomCount.put(entry.getKey(), atomCount.getOrDefault(entry.getKey(), 0) + entry.getValue() * num);
                }
            }
            i = j;
        }
        return atomCount;
    }
}