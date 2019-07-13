class MyCalendarThree {

    private TreeMap<Integer, Integer> bookTimes;

    public MyCalendarThree() {
        this.bookTimes = new TreeMap();
    }

    public int book(int start, int end) {
        bookTimes.put(start, bookTimes.getOrDefault(start, 0) + 1);
        bookTimes.put(end, bookTimes.getOrDefault(end, 0) - 1);

        int booked = 0, max = 0;
        for (int t : bookTimes.values()) {
            booked += t;
            max = Math.max(max, booked);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */