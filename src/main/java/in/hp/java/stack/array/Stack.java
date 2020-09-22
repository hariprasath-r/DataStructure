package in.hp.java.stack.array;

public class Stack {

    int[] stack = new int[5];
    int top = -1;

    public void push(int data) {
        if (top == 4)
            System.out.println("Stack Overflow");
        else
            stack[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            int data = stack[top];
            stack[top--] = 0;
            return data;
        }
    }

    public int peek() {
        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
//		if(top < 0)
//			return true;
//		else
//			return false;
        return top < 0;
    }

    public void display() {
        for (int i : stack)
            System.out.println(i);
        System.out.println();
    }
}
