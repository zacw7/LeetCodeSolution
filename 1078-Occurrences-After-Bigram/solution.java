class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> thirdList = new ArrayList();
        String[] words = text.split(" ");
        for (int i = 2; i < words.length; i++) {
            if (words[i - 2].equals(first) && words[i - 1].equals(second)) {
                thirdList.add(words[i]);
            }
        }
        return thirdList.toArray(new String[thirdList.size()]);
    }
}