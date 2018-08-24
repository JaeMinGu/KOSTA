class ReturnExample {
	public static void main(String[] args)	{
		System.out.println("프로그램 시작됨");

		int i;
		for(i = 0; i <= 100 ; i++){ 
			System.out.println(i + " " + "KOSTA 187기 화이팅!");
			if(i == 50){
				return; 
			}

		}//for

		
		System.out.println("프로그램 종료됨");
	}//main
}//class
