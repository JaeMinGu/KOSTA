import java.util.HashMap;
import java.util.Map;

public class Student {

	Map<String, Object> prop;

	public Student() {
		prop = new HashMap<>();
	}

	public Map<String, Object> getProp() {
		return prop;
	}

	public void setProp(Map<String, Object> prop) {
		this.prop = prop;
	}
	
	public void setProperty(String key, Object value) {
		prop.put(key, value);
		
	}
	
	public Object getProperty(String key) {
		return prop.get(key); 
				
	}
	
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setProperty("studentID", 84547);
		student1.setProperty("name", "김기정");
		
		Student student2 = new Student(); 
		student2.setProperty("studentID", 778445);
		student2.setProperty("name", "홍길동");
		student2.setProperty("address", "서울");
		
	}
	

	
}
