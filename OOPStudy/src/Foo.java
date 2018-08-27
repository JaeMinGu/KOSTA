public class Foo {

	public void move(Directions direction) {

		switch (direction) {

		case EAST:
			System.out.println("동쪽으로 이동");
			break;
		case WEST:
			System.out.println("서쪽으로 이동");
			break;
		case SOUTH:
			System.out.println("남쪽으로 이동");
			break;
		case NORTH:
			System.out.println("북쪽으로 이동");
			break;

		}
	}

	public static void main(String[] args) {
		Foo foo = new Foo();
		foo.move(Directions.EAST);
		foo.move(Directions.WEST);
		foo.move(Directions.SOUTH);
		foo.move(Directions.NORTH);

		Directions[] list = Directions.values();
		for (Directions directions : list) {
			System.out.println(directions.toString());
		}

		String name = "NORTH";
		Directions dir = Directions.valueOf(name);
		System.out.println(dir);

	}
}
