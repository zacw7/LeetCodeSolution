class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.isEmpty() || words.size() != words.get(0).length()) {
            return false;
        }

        for (int i = 0; i < words.size(); i++) {
            String s = words.get(i);
            for (int j = 0; j < s.length(); j++) {
                if (j >= words.size() || i >= words.get(j).length()
                        || s.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}