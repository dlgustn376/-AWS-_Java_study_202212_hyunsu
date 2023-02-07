package j20_JSON.복습1;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToMapExample {
  public static void main(String[] args) throws Exception {
    String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";

    ObjectMapper objectMapper = new ObjectMapper();
//    Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});
    Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});

    System.out.println(map);
  }
}



