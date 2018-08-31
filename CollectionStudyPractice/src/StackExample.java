import java.util.List;
import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {

		// push, pop, peek
		Stack<String> stack = new Stack<>();

		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
		stack.push("aaa");
		System.out.println(stack.size());

		stack.pop();
		System.out.println(stack.size());

		stack.peek();
		System.out.println(stack.size());

	}

}
