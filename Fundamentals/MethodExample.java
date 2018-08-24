class MethodExample {
	
	//method1 - instance method 
	static void printMessage(String name, String message){
		System.out.println("[" + name + "] : " + message); 
	}

	//method2 - instance method 
	static int sum(int x, int y, int z){
		return x + y + z; 
	}
	

	//method3 - instance method 
	static void printGugudan(int dan){
		
		for(int i=1; i<=9; i++){ 
			for(int j=2; j<=dan; j++){
				System.out.print(j + "*" + i + "=" + (i*j) + "  ");
			}
			System.out.println();
			
		}
	}



	//entry point - static method, class method
	public static void main(String[] args)	{
		String name = "�����";
		String message = "�ȳ��ϼ���.";

		printMessage(name, message); //method1, method2�� static �ٿ��� �����
		
		
		int result = sum(85, 75, 94);	//����� ������� int result �ʿ� 
		System.out.println(result);
		System.out.println(sum(85, 75, 94)); //��� ���� 
		
		printGugudan(5);
		printGugudan(9);	
		
		

	}//main


}//class
