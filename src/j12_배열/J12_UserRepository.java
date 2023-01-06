package j12_배열;

// 저장소
// 비즈니스 로직과 Entity를 가지 가지고 있으나, 비즈니스 로직에 가깝다.

	public class J12_UserRepository {
	
	//배열을 선언만 함.
	private J12_User[] userTable;						
	
	// 배열을 외부로 받아와서 쓰기 저장.
	public J12_UserRepository(J12_User[] userTable) {	
		this.userTable = userTable;
	}
	
	// setter가 필요 X
	public J12_User[] getUserTable() {
		return userTable;
	}
	
	// user 저장
	public void saveUser(J12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1]  = user; 
	}
	
	// 배열 확장
	private void extendArray(int length) {
		J12_User[] newArray = new J12_User[userTable.length + length];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	// 배열이 하나만 확장.
	private void extendArrayOne() {
		J12_User[] newArray = new J12_User[userTable.length + 1];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	// 배열이 확장될 때 실행 
	private void transferDataToNewArray(J12_User[] oldArray, J12_User[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	
	
}
