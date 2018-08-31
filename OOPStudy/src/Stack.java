/**
 * LIFO 구조의 스택 구현 
 * 
 * @author 최재민
 *
 */
public class Stack {
	/**
	 * instance variable
	 */
	private int[] array;
	private int count = 0 ;	//private 필수, 변수명 의미있게(e.g.count/top) 
	
	/**
	 * constructor
	 */
	public Stack() {
		this(10);
	}
	
	public Stack(int size) {
		array = new int[size];
	}
	
	/**
	 * instance method(push)				// 스택에 값을 저장하는 메소드 - 어떤 메소드인지 설명 적어주기 
	 * @param size
	 */
	
	public void push (int value) {
		array[count]= value; 
		count++;
	}
	
	
	/**
	 * instance method(pop)					// 스택에 저장된 값을 추출하는 메소드 
	 * @return
	 */
	public int pop() {
//		int top = array[i-1];
		int top = array[--count];
		count--;
		return top;
	}
	
	/**
	 * instance method(length)				// 스택의 길이 세는 메소드 
	 * @return
	 */
	public int length() {
		return count; 
	}
	
	 
	/**
	 * main method 
	 * @param args
	 */
	public static void main(String[] args) {
		Stack stack = new Stack(100);
		// push메소드 테스트 
		stack.push(5);
		stack.push(3);
		stack.push(2);
		
		// pop 메소드 테스트 
		System.out.println("추출된 값: " + stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		// length 메소드 테스트 
		System.out.println("길이: " + stack.length());
		
	}// main
}
