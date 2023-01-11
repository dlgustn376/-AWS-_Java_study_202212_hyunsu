package j16_Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectGetClass {
	public static void main(String[] args) {
		Student student = new Student("김재영", 29);
		
//		student는 Student 클래스로 만들어 졌다.
//		Student의 class 클래스의 정보만을 가져옴. 명확한 결과가 나옴.
//		Student가 Object 클래스는 아니다.
//		위 두개가 같은면 instanceof 상속되었을 때 문제가 있다.
		
		System.out.println(student.getClass());
		System.out.println(Student.class);
		
		System.out.println(student.getClass().getName());
		
		Class studentClass = student.getClass();
//		다른 패키지에 Student 클래스가 있을 수 있기 때문에 
//		패키지도 같이 찍힌다.
		String classname = studentClass.getName();
		
		System.out.println("클래스 이름: " + classname);
		
		String simpleName = studentClass.getSimpleName();
		System.out.println("클래스 이름만: " + simpleName);
		
		Field[] fields = studentClass.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field);
		}
		
		Method[] methods = studentClass.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
		
	}
}
