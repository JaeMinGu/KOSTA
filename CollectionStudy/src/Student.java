import java.util.HashMap;
import java.util.Map;

/**
 * 동적 객체 정의
 * 
 * @author 최재민
 *
 */
public class Student {
	Map<String, Object> prop;

	public Student() {
		prop = new HashMap<String, Object>();
	}

	public Map<String, Object> getProperty() {
		return prop;
	}

	public void setProp(Map<String, Object> property) {
		this.prop = property;
	}

	public void setProperty(String key, Object value) {
		prop.put(key, value);
	}

	public Object getProperty(String key) {
		return prop.get(key);
	}

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setProperty("ssn", 85464);
		student1.setProperty("name", "김기정");

		Student student2 = new Student();
		student2.setProperty("ssn", 45587);
		student2.setProperty("name", "박소연");
		student2.setProperty("address", "LA");
	
	}
}
