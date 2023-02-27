package j12_배열;

//저장소
public class J12_UserRepository {
	private J12_User[] userTable;

	public J12_UserRepository(J12_User[] userTable) { // alt + shift + s -> GCUF
		this.userTable = userTable;
	}

	public void saveUser(J12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1] = user; // 유저를 담는다.
	}

	public J12_User[] getUserTable() {
		return userTable;
	}

	private void extendArray(int length) { // 배열을 확장 한다는 의미이다.
		J12_User[] newArray = new J12_User[userTable.length + length]; // 공간이 length씩 늘어나는 구조이다.
		transferDataToNewArray(userTable, newArray); // userTable -> newArray로 이동
		userTable = newArray;
	}

	private void extendArrayOne() { // 배열을 한 개 확장 한다는 의미이다.
		J12_User[] newArray = new J12_User[userTable.length + 1]; // 공간이 하나씩 늘어나는 구조이다.
		transferDataToNewArray(userTable, newArray); // userTable -> newArray로 이동
		userTable = newArray;
	}

	private void transferDataToNewArray(J12_User[] oldArray, J12_User[] newArray) {
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}

	public J12_User findUserByUsername(String username) {
		J12_User user = null;
		
		for (J12_User u : userTable) {
			if (u == null) {
				continue;
			}
			if (u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		return user;
	}
}
