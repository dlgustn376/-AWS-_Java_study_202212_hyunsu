package j17_스태틱.싱글톤;

public class A {
	
	private static A instance = null;
	
	private Student[] students;
	
	public A() {
		students = new Student[3];
	}
	
	public static  A getInstace() {
		if(instance == null) {
			instance = new A();
		}
		return instance;
	}
	
	//학생 배열에 학생을 추가하는 메소드
	public void addStudent(Student student) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = student;
				return;
			}
		}
		
		System.out.println("더 이상 학생을 추가할 수 없습니다.");
		System.out.println();
		
	}
	
	public void printA() {
		System.out.println(getClass().getSimpleName());
	}
	
	//생성하면 학생 배열 5개 생김. 생성자
	

	// 학생 배열을 보여주는 메소드
	public void showStudents() {
		for(Student student : students) {
//		student.toString() 안됨.
			System.out.println(student);
		}
		System.out.println();
	}
	
	
	
	
	
}

//
//
