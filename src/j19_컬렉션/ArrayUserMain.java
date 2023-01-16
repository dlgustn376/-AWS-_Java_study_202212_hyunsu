package j19_컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

//1.
@AllArgsConstructor
@Data
class User{
	private String username;
	private String name;
}


public class ArrayUserMain {
	// username으로 name을 찾는 메소드
//	5.
	private static User searchUserName(List<User> userList, String searchUsername) {
		User user = null;
		for(User u : userList) {
			if(u.getUsername().equals(searchUsername)) {
				user = u;
				break;
			}
		}
		
		return user;
	}
	
	// 질문
	// userList에서 추가 하는 방법 모르겠음. 해결
	// userArray에 직접 넣는 방법 밖에 없나?
	
	
	public static void main(String[] args) {
//		2.
		User[] userArray = {
				new User("aaa", "김종환"),
				new User("bbb", "고병수"),
				new User("ccc", "손민재"),
				new User("ddd", "황창욱")
		};
//		3.
	
		List<User> users = new ArrayList<>();
		
		users.addAll(Arrays.asList(userArray));
		users.add(new User("abcd", "이현수"));
		

//		4.
		String serachUsername = "abcd";
		
		User user = searchUserName(users, serachUsername);
//		6.
		if(user == null) {
			System.out.println("검색 실패!");
			System.out.println("존재하지 않는 계정입니다.");
		}else {
			System.out.println("검색성공! ");
			System.out.println(user.getUsername() + "계정의 회원 이름은 " + user.getName() + "입니다.");
		}
			
		
		
//		boolean flag = true;
//		for(int i = 0; i < userList.size(); i++) {
//			User user = userList.get(i);
//			if(user.getUsername().equals(serachUsername)) {
//				System.out.println("검색성공! " + user.getUsername() 
//				+ "계정의 회원 이름은 " + user.getName() + "입니다.");
//				flag = false;
//				break;
//			}
//			
//		}
		
//		for(User un : userList) {
//			if(un.getUsername().equals(serachUsername)) {
//				System.out.println("검색성공! " + un.getUsername() 
//				+ "계정의 회원 이름은 " + un.getName() + "입니다.");
//				flag = false;
//				break;
//			}
//		}
//		
//		if(flag) {
//			System.out.println("검색 실패! 존재하지 않는 계정입니다.");
//		}
		
		
		
		
	}
	
}	
