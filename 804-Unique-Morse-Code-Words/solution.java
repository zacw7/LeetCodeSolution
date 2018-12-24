class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseDict = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."
        };
        Set<String> morseRepr = new HashSet();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0, length = word.length(); i < length; i++) {
                sb.append(morseDict[word.charAt(i) - 'a']);
            }
            morseRepr.add(sb.toString());
        }
        return morseRepr.size();
    }
}