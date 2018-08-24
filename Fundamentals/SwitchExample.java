class SwitchExample {
	public static void main(String[] args)	{
		
		int x = 4; 
		
		switch(x){
			case 1 : System.out.println("1"); break; //break: "중괄호 바깥"으로 "이동"시킨다는 의미  		
			case 2 : System.out.println("2"); break; 	
			case 3 : System.out.println("3"); break; 		
			case 4 : System.out.println("4"); break; 		
			case 5 : System.out.println("5"); break; 		
			case 6 : System.out.println("6"); break; 		
			case 7 : System.out.println("7"); break; 
			default : System.out.println("올바른 값이 아닙니다.");
		}


		// 사칙연산 케이스 
		x = 70;
		int y = 25; 
		String opp = "%";

		switch(opp){
			case "+" : System.out.println(x+y); break; 
			case "-" : System.out.println(x-y); break; 	
			case "*" : System.out.println(x*y); break; 		
			case "/" : System.out.println(x/y); break; 		
			default : System.out.println("지원되지 않는 연산자입니다."); 
		}
	}
}
