class Solution {
    public String toGoatLatin(String S) {
        Set<Character> vowelSet = new HashSet();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');

        String[] words = S.split(" ");

        for (int i = 1; i <= words.length; i++) {
            String word = words[i - 1];
            StringBuilder sb = new StringBuilder();
            if (vowelSet.contains(word.charAt(0))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1, word.length()));
                sb.append(word.charAt(0));
            }
            sb.append("ma");
            for (int c = i; c > 0; c--) {
                sb.append('a');
            }
            words[i - 1] = sb.toString();
        }
        return String.join(" ", words);
    }
}