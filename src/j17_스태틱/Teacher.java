package j17_스태틱;

public class Teacher {
	private String name;
	
	public Teacher(String name) {
		this.name = name;
	} // all argument constructor

	@Override // Alt + Shift + S -> ToString
	public String toString() {
		return "Teacher [name=" + name + "]";
	}
	
	

}
