import java.util.Set;
import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {

		// push, pop, peek

		Stack<String> stack = new Stack<>();
		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");

		System.out.println(stack.size()); // 3

		
		System.out.println(stack.peek()); 
		
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());

		System.out.println(stack.size()); // 0

	}

}
