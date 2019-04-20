// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Queue<Integer> queue;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.queue = new LinkedList();
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (queue.isEmpty() && iterator.hasNext()) {
            queue.offer(iterator.next());
        }
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (queue.isEmpty() && iterator.hasNext()) {
            queue.offer(iterator.next());
        }
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        if (queue.isEmpty() && iterator.hasNext()) {
            queue.offer(iterator.next());
        }
        return !queue.isEmpty();
    }
}