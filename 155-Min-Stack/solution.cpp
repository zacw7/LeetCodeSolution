class MinStack {
private:
    stack<int> myStack, minStack;
public:
    void push(int x) {
        if(myStack.empty() || minStack.empty()) {
            myStack.push(x);
            minStack.push(x);
        } else {
            myStack.push(x);
            minStack.push((x < minStack.top()) ? x : minStack.top());
            
        }
    }

    void pop() {
        if(!myStack.empty() && !minStack.empty()) {
            myStack.pop();
            minStack.pop();
        }
    }

    int top() {
        return myStack.top();
    }

    int getMin() {
        return minStack.top();
    }
};