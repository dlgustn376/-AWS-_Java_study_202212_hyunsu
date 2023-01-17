package usermanagement.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	/* 여기서 부터
	public Map<String, String> register(String userJson) {
		User user =  gson.fromJson(userJson, User.class);
		
		if(duplicatedUsername(user.getUsername())) {
			System.out.println("중복된 username이 있습니다.");
		}
		return null;
		
	}
	*/
	// 중복된 username이 있음을 체크
	private boolean duplicatedUsername(String username) {
		return userRepository.findUserByUsername(username) != null;
	}
	
}
