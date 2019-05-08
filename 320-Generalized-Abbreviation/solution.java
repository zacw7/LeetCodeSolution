class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> abbreviations = new ArrayList();
        if (word != null) {
            abbreviateHelper(word, "", 0, 0, abbreviations);
        }
        return abbreviations;
    }

    private void abbreviateHelper(String word, String cur, int index, int abbreviated, List<String> abbreviations) {
        if (index >= word.length()) {
            if (abbreviated > 0) {
                cur = cur + abbreviated;
            }
            abbreviations.add(cur);
        } else {
            if (abbreviated > 0) {
                abbreviateHelper(word, cur + abbreviated + word.charAt(index), index + 1, 0, abbreviations);
            } else {
                abbreviateHelper(word, cur + word.charAt(index), index + 1, 0, abbreviations);
            }

            abbreviateHelper(word, cur, index + 1, abbreviated + 1, abbreviations);
        }
    }
}