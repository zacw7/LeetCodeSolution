/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {

    private Queue<Character> queue = new LinkedList();

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        while (n > queue.size()) {
            char[] originBuff = new char[4];
            int count = read4(originBuff);
            for (int i = 0; i < count; i++) queue.offer(originBuff[i]);
            if (count < 4) break;
        }
        int len = n;
        if (queue.isEmpty()) len = 0;
        else if (queue.size() <= n) len = queue.size();
        for (int i = 0; i < len; i++) buf[i] = queue.poll().charValue();
        return len;
    }
}