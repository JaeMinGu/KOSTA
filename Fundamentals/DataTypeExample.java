/**
 * �ڹ� ���������� �׽�Ʈ 
 */

class DataTypeExample {
	public static void main(String[] args)	{
		//boolean
		boolean flag = true; //false 		
		//boolean flag2 = 10; //������ ���� 
		System.out.println(flag);


		//char
		char x = '\uD55C'; //��
		char y = '\uAE00'; //��
		
		System.out.println(x);
		System.out.println(y);


		//Ư������(���� ����, ���������� ����)
		System.out.println("��\b��� \n�л�\t�Դϴ�.");
		System.out.println("\"�ڹ�\"�� ���ƿ�");
		

		//byte, short, int, long 
		long money = 50000000L; 
		System.out.println(money);
		System.out.print("������");
		System.out.printf("%d", 100);

		//float, double
		float pi = 3.141592F; 
		double pi2 = 3.141592;
		
		//������ overLoading
		String info = "\n�ٳ���" + 30 + 10;
		System.out.println(info);
	}
}
