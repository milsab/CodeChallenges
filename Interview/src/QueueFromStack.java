import java.util.EmptyStackException;
import java.util.Stack;

public class QueueFromStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void add(Integer record){
        stack1.push(record);
    }

    public int remove(){
        Integer result = null;
        try {
            while(stack1.size() > 0){
                stack2.push(stack1.pop());
            }
            result = stack2.pop();

            while(stack2.size() > 0){
                stack1.push(stack2.pop());
            }
        } catch (EmptyStackException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
