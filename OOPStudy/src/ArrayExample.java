/**
 * 1차원 배열 선언, 생성, 초기화 
 * @author 최재민
 * */
public class ArrayExample {

	public static void main(String[] args) {
		int[] array; // 선언 
		array = new int[10]; // 생성 
		
		array[0] = 10; 
		array[9] = 100; 
		
//		System.out.println(array[0]); 
//		System.out.println(array[9]);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
		
		// 선언, 생성, 초기화 동시에 
		int[] array2 = new int[]{1, 2, 3, 4, 5};
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + "\t");
		}
		System.out.println();
		
		// 향상된 for문 (== 확장 for문)
		for(int value : array2) {
			System.out.print(value + "\t");
			
		}
		System.out.println();
		
		// 선언, 생성, 초기화 동시에 
		int[] array3 = {5, 6, 7, 8, 9};
		
		for (int i = 0; i < array3.length; i++) {
			System.out.print(array3[i] + "\t");
		}
		System.out.println();
		
		
		// 미션1(배열복사) 
		int[] array4 = {3, 1, 9, 2, 5};
		int[] array5 = new int[array4.length + 2];
		
		for (int i = 0; i < array4.length; i++) {
			array5[i] = array4[i];
		}
		System.out.println();
		
		for (int i : array5) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		// 미션2(정렬)
		int[] lottos = {34, 12, 3, 9, 25, 2};
		// 정렬 코드 	
		
		for (int i = 0; i < lottos.length; i++) {
			for(int j = 0; j < lottos.length-1; j++) {
				int temp = 0; 
				if(lottos[j] > lottos[j+1]) {
					temp = lottos[j]; 
					lottos[j] = lottos[j+1]; 
					lottos[j+1] = temp; 
				}
				
			}
			
		}		
		
		
		for (int value : lottos) {
			System.out.print(value + "\t");
		}
		
		
	}

}
