/** 
 * 배열 관련한 공통 기능 정의 
 * @author 최재민
 * */
public class ArrayUtil {

	/**
	 * 배열 복사 
	 *  
	 * @param src			복사하고자 하는 원본 배열
	 * @param increment		증가치
	 * @return				복사된 배열 
	 */
	public static int[] copy(int[] src, int increment) {		// Call By Reference (cf. Call By Value)
		int[] array = new int[src.length + increment];
		
		for (int i = 0; i < src.length; i++) {
			array[i] = src[i];
		}
		
		return array;
	}
	
	
	/**
	 * 배열 오름차순 정렬
	 * 
	 * @param src			원본 배열 
	 */
	public static void sort(int[] src) {
		for (int i = 0; i < src.length; i++) {
			for (int j = 0; j < src.length - 1; j++) {
				int temp = 0;
				if (src[j] > src[j + 1]) {
					temp = src[j];
					src[j] = src[j + 1];
					src[j + 1] = temp;
				}

			}

		}

	}
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 7, 9};
		int[] copy = ArrayUtil.copy(array, 4);
		
		for (int i : copy) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		ArrayUtil.sort(array);
		for (int i : array) {
			System.out.print(i + "\t");
		}
		
	}//main
	
	
}
