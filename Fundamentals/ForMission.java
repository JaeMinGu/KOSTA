class ForMission {
	public static void main(String[] args)	{
		// Q1
		/*
		for(int i=0; i<5; i++){
			switch(i){
				case 0 : System.out.println("*"); break; 
				case 1 : System.out.println("**"); break; 
				case 2 : System.out.println("***"); break; 
				case 3 : System.out.println("****"); break; 
				case 4 : System.out.println("*****"); break; 
			}
			
			
		}*/
		

		// Q1 ���ʴ�� �ﰢ��(��)
		/*
		for(int j=0; j<6; j++){
			for(int k=0; k<j; k++){
				System.out.print("*"); 
			}
			System.out.println();
			
		}*/
		

		// Q2 ���ʴ�� �ﰢ��(��)
		
		/*
		for(int l=5; l>0; l--){
			for(int m=0 ; m<l; m++){
				System.out.print("*");
			}
			System.out.println();
		}
		*/


		// Q3 �������� �ﰢ��(��)

		/*
			    *
			   **
			  ***
			 ****
			*****
		*/
		
		/*
		for(int m=0; m<5;m++){
			for(int n=0; n<5-m; n++){
				System.out.print(" ");
			}
			for(int o=0; o<=m; o++){
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		

		// Q4 �������� �ﰢ��(��)
		/*
			for(int i=0; i<5; i++){
			for(;;){
				System.out.print(" ");			
			}
			for(;;){
				System.out.println("*");
			}
			System.out.println();
		}
		*/

		// Q5 ������(����)
		/*
		for(int i=1; i<=9; i++){
			for(int j=2; j<=9; j++){
				System.out.print(j + "*" + i + "=" + (i*j) + "  ");
			}
			System.out.println();
		}
		*/

	}
}
