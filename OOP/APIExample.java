/**
 * Java ǥ�� API�� �⺻ Ŭ���� ����ϱ�
 */

public class APIExample {
	public static void main(String[] args)	{
		// ����� ����(������ ȣ��)
		String str; 
		str = new String("�ڹٰ� �Ⱦ��..."); 
		
		// ������ ����
		str = "new String()�� ���� �ǹ�"; 

		int length = str.length();
		System.out.println(length);

		char firstLetter = str.charAt(0);
		System.out.println(firstLetter);

		int x = -20; 
		System.out.println(Math.abs(x));
	}
}
