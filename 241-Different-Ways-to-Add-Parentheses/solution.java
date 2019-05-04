class Solution {
    Map<String, List<Integer>> cache = new HashMap();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList();
        if (input == null || input.length() == 0) {
            return res;
        }
        if (cache.containsKey(input)) {
            return cache.get(input);
        }
        int firstOper = 0;
        while (firstOper < input.length()) {
            if (!Character.isDigit(input.charAt(firstOper))) {
                break;
            }
            firstOper++;
        }
        if (firstOper == input.length()) {
            res.add(Integer.valueOf(input));
            return res;
        }
        for (int i = firstOper; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(input.charAt(firstOper))) {
                List<Integer> lList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rList = diffWaysToCompute(input.substring(i + 1, input.length()));
                for (int lNum : lList) {
                    for (int rNum : rList) {
                        switch(c) {
                            case '+': res.add(lNum + rNum); break;
                            case '-': res.add(lNum - rNum); break;
                            case '*': res.add(lNum * rNum); break;
                            default: break;
                        }
                    }
                }
            }
        }
        cache.put(input, res);
        return res;
    }
}