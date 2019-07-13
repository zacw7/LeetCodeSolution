class MyCalendar {

    List<int[]> books;

    public MyCalendar() {
        this.books = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] b : books) {
            if (b[1] <= start || end <= b[0]) {
                continue;
            } else {
                return false;
            }
        }
        books.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */