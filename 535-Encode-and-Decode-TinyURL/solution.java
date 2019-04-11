public class Codec {

    private Map<String, String> store = new HashMap();
    private char CLASH_CHAR = '#';
    private String URL_PREFIX = "https//tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = base62Converse(Math.abs(longUrl.hashCode()));
        while (store.containsKey(shortUrl)) {
            if (store.get(shortUrl).equals(longUrl)) return shortUrl;
            longUrl += CLASH_CHAR;
            shortUrl = base62Converse(Math.abs(longUrl.hashCode()));
        }
        shortUrl = URL_PREFIX + shortUrl;
        store.put(shortUrl, longUrl);
        return shortUrl;
    }

    private String base62Converse(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int digit = num % 62;
            if (digit < 10) sb.append((char) (digit + '0'));
            else if (digit < 36) sb.append((char) (digit - 10 + 'a'));
            else sb.append((char) (digit - 36 + 'A'));
            num /= 62;
        }
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return store.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));