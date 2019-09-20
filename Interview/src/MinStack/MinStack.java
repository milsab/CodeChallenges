package MinStack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milad
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(0);
        minStack.push(2);
        minStack.push(-4);
        minStack.push(5);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    class Node {

        int val;
        int min;

        public Node(int v, int m) {
            this.val = v;
            this.min = m;
        }

        public int getVal() {
            return this.val;
        }

        public void setVal(int v) {
            this.val = v;
        }

        public int getMin() {
            return this.min;
        }

        public void setMin(int m) {
            this.min = m;
        }
    }

    private List<Node> list;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        if (list.size() == 0) {
            Node node = new Node(x, x);
            list.add(node);
        } else {
            int min = Math.min(list.get(list.size() - 1).getMin(), x);
            Node node = new Node(x, min);
            list.add(node);
        }
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1).getVal();
    }

    public int getMin() {
        return list.get(list.size() - 1).getMin();
    }
}
