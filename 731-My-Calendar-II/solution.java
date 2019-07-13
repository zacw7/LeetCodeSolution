class MyCalendarTwo {

    private TreeMap<Integer, Integer> bookTimes;

    public MyCalendarTwo() {
        this.bookTimes = new TreeMap();
    }

    public boolean book(int start, int end) {
        bookTimes.put(start, bookTimes.getOrDefault(start, 0) + 1);
        bookTimes.put(end, bookTimes.getOrDefault(end, 0) - 1);
        int booked = 0;
        for (int t : bookTimes.values()) {
            booked += t;
            if (booked > 2) {
                break;
            }
        }
        if (booked > 2) {
            if (bookTimes.get(start) == 1) {
                bookTimes.remove(start);
            } else {
                bookTimes.put(start, bookTimes.get(start) - 1);
            }
            if (bookTimes.get(end) == -1) {
                bookTimes.remove(end);
            } else {
                bookTimes.put(end, bookTimes.get(end) + 1);
            }
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */