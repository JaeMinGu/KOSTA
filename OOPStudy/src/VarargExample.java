public class VarargExample {

	public static int sum(int[] args) {
		int result = 0;
		for (int i : args) {
			result += i;

		}
		return result;
	}

	public static int summ(int... args) {
		int result = 0;
		for (int i : args) {
			result += i;

		}
		return result;
	}

	public static void main(String[] args) {
		int[] values = { 10, 20 };
		sum(values);
		System.out.println(sum(values));
		summ(10);
		summ(10, 20);
		summ(10, 20, 30);
		summ(10, 20, 30, 40);

		System.out.println(summ(10, 20, 30));
	}

}
