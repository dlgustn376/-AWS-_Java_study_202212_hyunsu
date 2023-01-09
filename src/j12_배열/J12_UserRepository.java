package j12_배열;

// 저장소
public class J12_UserRepository {

	private J12_User[] userTable;
	
	// userTable은 UserRepository에 의존하고 있다.
	public J12_UserRepository(J12_User[] userTable) {
		this.userTable = userTable;
	}
	
	public J12_User[] getUserTable() {
		return userTable;
	}
	
	// 유저를 저장하는 메소드
	public void saveUser(J12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1] = user;
	}
	
	// 배열을 여러개 늘리는 메소드
	private void extendArray(int length) {
		J12_User[] newArray = new J12_User[userTable.length + length];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	// 배열을 하나 늘리는 메소드
	private void extendArrayOne() {
		J12_User[] newArray = new J12_User[userTable.length + 1];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	// 배열이 확장했을때 값을 복사하는 메소드
	private void transferDataToNewArray(J12_User[] oldArray, J12_User[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	// 유저이름(ID)를 검색하여 정보를 찾아냄.
	// 찾아주는 역할만 함.
	public J12_User findUserByUsername(String username) {
		
		// 빈 user 객체
		J12_User user = null;
		
		// 첫 번째 유저객체 부터 확인
		for(J12_User u: userTable) {
			// 객체는 null 체크 필수
			if(u == null) {
				continue;
			}
			// username에서 입력한 문자열과 같은지 확인
			if(u.getUsername().equals(username)) {
				user = u;
				break;	// 찾으면 반복문에서 탈출
			}
		}
		
		return user;
	}
	
	
	/*
	 *	1. 사용자이름으로 회원 조회
	 *
	 *	2. 회원 정보 수정
	 *		
	 *		수정할 사용자 이름을 입력하세요:
	 *	
	 *		<< 사용자이름: aaa >>
	 *
	 *		1. 비밀번호 변경 기존 비밀번호 일치 
	 *		2. 이름 변경
	 *		3. 이메일 변경
	 *
	 *		b. 뒤로가기
	 *
	 *
	 *
	 * */	
	
	
	/*
	// 수정하는 메소드
	public J12_User changeData(String passward, String name, String email) {
		
		J12_User user = null;
		
		
		
		return ;
	}
	
	*/
	
	
}







