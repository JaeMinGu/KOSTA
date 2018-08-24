class WhileExample {
	public static void main(String[] args)	{
		
		int i = 0; // i : index
		
		while(i < 10){
			System.out.println(i + " " + "KOSTA 187기 화이팅!");
			i++;
		}


		// 누적 합 구하기 
		i = 0;
		int sum = 0, oddSum = 0, evenSum = 0; 

		while(i <= 100){
			
			if(i %2 != 0){ //홀수 
				oddSum += i; 
			}else{ //짝수
				evenSum += i; 
			} 
			i++;
		}

		System.out.println("\n전체 합 : " + (oddSum + evenSum));
		System.out.println("홀수 합 : " + oddSum);
		System.out.println("짝수 합 : " + evenSum);
		
		


		
	
	}
}
