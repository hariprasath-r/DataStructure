package hp.java.stack.array;

/**
 * Dynamic stack is an scalable stack.
 * There will be 2 functions
 * {@code private void expand()}
 * Expand will expand the size of stack array by twice its capacity
 * {@code private void shrink()}
 * Shrink will shrink the size of stack array by two times its capacity
 * 
 * @author Hariprasath
 *
 */
public class DStack {

	int capacity = 2;
	int[] stack = new int[capacity];
	int top = -1;
	
	public void push(int data) {
		if(capacity == size())
			expand();
		stack[++top] = data;
	}
	
	/**
	 * Function will create a new array with 2 times the size of existing array
	 * Uses {@code System.arraycopy() method to copy values from one array to another}
	 */
	private void expand() {
		int length = size();
		int[] newStack = new int[capacity * 2];
		System.arraycopy(stack, 0, newStack, 0, length);
		capacity *= 2;
		stack = newStack;
	}

	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			int data = stack[top];
			stack[top--] = 0;
			shrink();
			return data;
		}
	}
	
	/**
	 * If array has 3/4th number of elements than its size
	 * We are shrinking the size as half.
	 */
	private void shrink() {
		int length = size();
		if(length <= (capacity / 2) / 2)
			capacity /= 2;
		int[] newStack = new int[capacity];
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
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
		for(int i : stack)
			System.out.print(i+" ");
	}
}
