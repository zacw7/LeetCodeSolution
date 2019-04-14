class ValidWordAbbr {

    private Map<String, Integer> dict;

    public ValidWordAbbr(String[] dictionary) {
        this.dict = new HashMap();
        for (String word : dictionary) {
            if (word == null || word.length() < 2 || dict.containsKey(word)) continue;
            dict.put(word, 1);
            String abbr = getAbbreviation(word);
            dict.put(abbr, dict.getOrDefault(abbr, 0) + 1);
        }
    }

    public boolean isUnique(String word) {
        if (word == null || word.length() == 0) return true;
        if (word.length() > 2) {
            if (dict.containsKey(word)) {
                return dict.getOrDefault(getAbbreviation(word), 0) - 1 == 0;
            } else {
                return dict.getOrDefault(getAbbreviation(word), 0) == 0;
            }
        }
        return true;
    }

    private String getAbbreviation(String s) {
        return s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() -1, s.length());
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */