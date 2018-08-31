import java.util.LinkedList;

public class QueExample {

	public static void main(String[] args) {

		LinkedList<String> que = new LinkedList<>();

		que.offer("a");
		que.offer("b");
		que.offer("c");
		que.offer("d");

		System.out.println(que.size());
		que.peek();
		System.out.println(que.size());

		que.poll();
		System.out.println(que.size());

	}

}
