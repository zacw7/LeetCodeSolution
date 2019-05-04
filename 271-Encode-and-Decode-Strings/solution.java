public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            if (i > 0) {
                sb.append("/#/");
            }
            String str = strs.get(i);
            if (str.length() == 0) {
                sb.append("?#?");
            } else {
                sb.append(str.replaceAll("#", "##"));
            }
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList();
        if (s == null || s.length() == 0) {
            return res;
        }
        String[] strs = s.split("/#/");
        for (String str : strs) {
            if (str.equals("?#?")) {
                res.add("");
            } else {
                res.add(str.replaceAll("##", "#"));
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));