package j20_JSON;

import com.google.gson.Gson;

public class Json3 {
	public static void main(String[] args) {

		Gson gson = new Gson();
		
		System.out.println(Integer.valueOf("101") + 3536);
		System.out.println(Integer.parseInt("101") + 3536);
		
		gson.toJson(null);				 // object	-> json
		gson.fromJson("", Object.class); // json	-> object

	}

}
