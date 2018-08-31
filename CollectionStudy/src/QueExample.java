import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class QueExample {

	public static void main(String[] args) {

		// First In First Out (FIFO)

		LinkedList<String> que = new LinkedList<String>();

		que.offer("aaa");
		que.offer("bbb");
		que.offer("ccc");
		que.offer("ddd");
		que.offer("eee");

//		que.poll();
//		que.poll();
//		que.poll();
//		System.out.println(que.poll());

		que.peek();
		System.out.println(que.size());
		
	}

}
