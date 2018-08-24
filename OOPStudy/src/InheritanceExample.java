
public class InheritanceExample {

	public static void main(String[] args) {

		Bicycle bicycle;
		bicycle = new Bicycle(10, "삼천리");

		System.out.println(bicycle.id);
		System.out.println(bicycle.brand);
		bicycle.running();
		System.out.println();

		MountainBicycle mountainBicycle = new MountainBicycle(10, "삼천포", "카본", true);
		// 재사용
		System.out.println(mountainBicycle.id);
		System.out.println(mountainBicycle.brand);
		// 확장
		System.out.println(mountainBicycle.frame);
		System.out.println(mountainBicycle.suspension);
		
		
		mountainBicycle.running();

	}

}
