import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionExample {

	public static void main(String[] args) {

		String str = "Reflection이 뭔가요? ......";

		Class cls = str.getClass();
		System.out.println(cls.getModifiers()); // 17
		System.out.println(Modifier.PUBLIC); // 1
		System.out.println(cls.getName()); // java.lang.String
		System.out.println(cls.getSimpleName()); // String
		System.out.println(cls.getSuperclass()); // class java.lang.Object
		System.out.println(cls.getSuperclass().getName()); // java.lang.Object

		Field[] fs = cls.getFields();
		for (Field field : fs) {
			System.out.println(field.getName());
		}

		Method[] ms = cls.getMethods();
		for (Method method : ms) {
			System.out.println(method.getName());
		}
	}

}
