import java.util.Scanner; 

class IfExample {
	
	public static void main(String[] args)	{
		int score = 96; 
		
		// 100�� �̸� 
		if(score < 100){
			System.out.println("���� : " + score); //1�����̶� {}�ȿ� �ۼ��ϱ�
			
		}

		// 60�� �̻� or not 
		if(score >= 60){
			System.out.println("60�� �̻�? YES(Pass)");		
		}else{
			System.out.println("60�� �̻�? NO(Fail)");
		}

		// Ȧ�� or ¦�� 
		if((score % 2) == 0){    // ������ ���� (score % 2)
			System.out.println("Even");
			if(score >= 50){
				System.out.println("50�� �̻�? YES");
			}else{
				System.out.println("50�� �̻�? NO");
			}
		}else{
			System.out.println("Odd");
		}
		

		// ���� �Է� �ޱ� 		
		System.out.print("���� : ");
		Scanner sc = new Scanner(System.in);
		score = sc.nextInt();

		// ����̾簡 
		if(score >= 90){
			System.out.println("��");
		}else if(score >=80){
			System.out.println("��");
		}else if(score >=70){
			System.out.println("��");
		}else if(score >=60){
			System.out.println("��");
		}else{
			System.out.println("��");
		}
		
		
	}
}
