class ForExample {
	public static void main(String[] args)	{
		int i;
		for(i = 0; i <= 100 ; i++){ // i : block scope �������� ��밡��
			System.out.println(i + " " + "KOSTA 187�� ȭ����!");
		}//for

		System.out.println(i); // ������ ���� (cannot find symbol)
		

		// ������ ���ϱ� 
		int sum = 0; 
		for(int j = 0; j <= 100; j++){
			sum += j;
			
		}
		
		System.out.println("1 ~ 100 �� : " + sum);

		// ���簢�� ����
		for(int j=0; j<5; j++){
			for(int k=0; k<5; k++){
				System.out.print("*");
			}
			System.out.println();
		}


		

	}//main
}//class
