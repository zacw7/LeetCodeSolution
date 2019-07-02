import javafx.util.Pair;

class StockSpanner {

    private Stack<Pair<Integer, Integer>> stack;

    public StockSpanner() {
        this.stack = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!stack.isEmpty() && stack.peek().getKey() <= price) {
            w += stack.pop().getValue();
        }
        stack.push(new Pair(price, w));
        return w;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */