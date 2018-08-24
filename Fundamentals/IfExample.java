import java.util.Scanner; 

class IfExample {
	
	public static void main(String[] args)	{
		int score = 96; 
		
		// 100점 미만 
		if(score < 100){
			System.out.println("점수 : " + score); //1문장이라도 {}안에 작성하기
			
		}

		// 60점 이상 or not 
		if(score >= 60){
			System.out.println("60점 이상? YES(Pass)");		
		}else{
			System.out.println("60점 이상? NO(Fail)");
		}

		// 홀수 or 짝수 
		if((score % 2) == 0){    // 가독성 위해 (score % 2)
			System.out.println("Even");
			if(score >= 50){
				System.out.println("50점 이상? YES");
			}else{
				System.out.println("50점 이상? NO");
			}
		}else{
			System.out.println("Odd");
		}
		

		// 점수 입력 받기 		
		System.out.print("점수 : ");
		Scanner sc = new Scanner(System.in);
		score = sc.nextInt();

		// 수우미양가 
		if(score >= 90){
			System.out.println("수");
		}else if(score >=80){
			System.out.println("우");
		}else if(score >=70){
			System.out.println("미");
		}else if(score >=60){
			System.out.println("양");
		}else{
			System.out.println("가");
		}
		
		
	}
}
