package j20_JSON.복습1;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapToJsonExample {
  public static void main(String[] args) throws Exception {
    Map<String, Object> map = new HashMap<>();
    map.put("name", "John");
    map.put("age", 30);
    map.put("city", "New York");

    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(map);

    System.out.println(json);
  }
}
