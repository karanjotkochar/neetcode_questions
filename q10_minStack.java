import java.util.Stack;

public class q10_minStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println("stack: " + minStack.print());

        minStack.getMin1();
        System.out.println("get min: " + minStack.getMin1());

        minStack.pop();
        System.out.println("get popped");

        minStack.top();
        System.out.println("get top: " + minStack.top());

        minStack.getMin1();
        System.out.println("get min: " + minStack.getMin1());

        System.out.println("stack: " + minStack.print());
    }
}

class MinStack {
    private Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    public void push(int val) {
        stack.push(val);
    }
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin1() {
        // using stream:  comparison takes time = o(n)
        return stack.stream().min(Integer::compare).orElseThrow();
    }

    public int getMin2() {
        // brute force method
        // time o(n) = n
        Stack<Integer> temp = new Stack<>();
        int mini = stack.peek();

        // get minimum by comparison and iterate whole stack (reverse)
        while (!stack.isEmpty()) {
            mini = Math.min(mini, stack.peek());
            temp.push(stack.pop())  ;
        }

        // restore stack back
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return mini;
    }

    public Stack<Integer> print() {
        return stack;
    }
}

class MinStack2 {
    // optimal solution -- two stacks
    // time o(n) = 1 and space o(n) = n
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    public void pop() {
        if (stack.isEmpty())
            return;
        int top = stack.pop(); // stack popped here and value is then compared with min-stack
        if (top == minStack.peek())
            minStack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }

}
