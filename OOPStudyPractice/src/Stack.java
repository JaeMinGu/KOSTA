public class Stack {
	
	private int[] stack;
	private int count = 0;

	public Stack() {

	}

	public Stack(int size) {
		stack = new int[size];
	}

	public void push(int value) {
		stack[count] = value;
		count++;
	}

	public int pop() {
		int top = stack[--count];
		System.out.println(top);
		return top;
	}

	public int size() {
		int size = count;
		System.out.println("stack의 크기: " + size);
		return size;
	}

	public static void main(String[] args) {
		Stack stack = new Stack(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		stack.size();

	}

}