package j09_클래스Test.example;

public class PersonMain {
	
	public static void main(String[] args) {
		Person person = new Person();
		
		person.setAge(40);
		person.setName("James");
		person.setMarried(true);
		person.setnumberOfChild(3);
		
		System.out.println("이 사람의 나이: " + person.getAge());
		System.out.println("이 사람의 이름: " + person.getName());
		System.out.println("이 사람의 결혼 여부: " + person.isMarried());
		System.out.println("이 사람의 자녀 수: " + person.getnumberOfChild());
	}
	
}
