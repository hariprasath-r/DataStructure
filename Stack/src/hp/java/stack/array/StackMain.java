package hp.java.stack.array;

public class StackMain {

	public static void main(String[] args) {
		DStack stack = new DStack();
		System.out.println("Is stack empty : "+stack.isEmpty());
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println("Top element : "+stack.peek());
		stack.display();
		System.out.println("Size of stack : "+stack.size());
		System.out.println("Pop : "+stack.pop());
		System.out.println("Size of stack : "+stack.size());
		System.out.println("Top element : "+stack.peek());
		stack.display();
		System.out.println("Is stack empty : "+stack.isEmpty());
		stack.push(31);
		stack.push(41);
		stack.push(31);
		stack.push(41);
		stack.display();
	}
}
