package usermanagement.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.mindrot.jbcrypt.BCrypt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import usermanagement.entity.User;
import usermanagement.repository.UserRepository;

public class UserService {
	private UserRepository userRepository;
	private Gson gson;
	
	private static UserService instance;
	
	
	
	public static UserService getInstance() {
		if(instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	private UserService() {
		userRepository = UserRepository.getInstance();
		gson = new GsonBuilder().setPrettyPrinting().create();
	}

	public Map<String, String> register(String userJson) {
//		response : 응답
		Map<String, String> response = new HashMap<>();
		
		Map<String, String> userMap = gson.fromJson(userJson, Map.class);
		for(Entry<String, String> userEntry : userMap.entrySet()) {
			
			if(userEntry.getValue().isBlank()) {
				response.put("error", userEntry.getKey() + "은(는) 공백일 수 없습니다.");
				return response;
			}
		}
		
		
		User user =  gson.fromJson(userJson, User.class);
		System.out.println("서비스에 넘어옴! User 객체로 변환");
		System.out.println(user);
		
		if(duplicatedUsername(user.getUsername())) {
			response.put("error", "이미 사용중인 사용자 이름입니다.");
			return response;
		}
		if(duplicatedEmail(user.getEmail())) {
			response.put("error", "이미 가입된 이메일입니다.");
			return response;
		}
		System.out.println(user);
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		System.out.println("암호화 후");
		System.out.println(user);

		userRepository.saveUser(user);
		System.out.println();
		response.put("ok", "회원 가입 성공!!");
		return response;
		
	}
	
	public Map<String, String> login(String userJson){
		Map<String, String> response = new HashMap<>();
		
		Map<String, String> userMap = gson.fromJson(userJson, Map.class);

		String username = userMap.get("username");
		String password = userMap.get("password");
		User user = UserRepository.getInstance().findUserByUsername(username);

		if(user == null) {
			user = UserRepository.getInstance().findUserByEmail(username);
			if(user == null) {
				response.put("error", "일치하지 않는 사용자입니다.");
				return response;
			}
		}
		
		if(!(BCrypt.checkpw(password, user.getPassword()))) {
			response.put("error", "일치하지 않는 사용자입니다.");
			return response;
		}

		
		response.put("ok", "로그인 성공!!");
		
		return response;
		
	}
	
	
	// 중복된 username이 있음을 체크
	private boolean duplicatedUsername(String username) {
		return userRepository.findUserByUsername(username) != null;
	}
	
	private boolean duplicatedEmail(String email) {
		return userRepository.findUserByEmail(email) != null;
	}
	
	
	
	
	
//	public void checkRegister(String userJson) {
//		Map<String, String> response = new HashMap<>();
//		
//		Map<String, String> userMap = gson.fromJson(userJson, Map.class);
//		User user =  gson.fromJson(userJson, User.class);
//		String pw = BCrypt.hashpw(userJson.toString(), BCrypt.gensalt());
//		
//				BCrypt.checkpw(user.getPassword(), BCrypt.gensalt());
//		
//		
//		System.out.println(pw);
//		System.out.println(BCrypt.checkpw("1234", pw));
//		user.setPassword(pw);
//	
//		
//		
//	}
	

	
	
	
//	private boolean isBlank(User user) {
//		
//		return user == null;
//	}
	
	
	
	
	
	
	
}
