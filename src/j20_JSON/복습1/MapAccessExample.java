package j20_JSON.복습1;

import java.util.HashMap;
import java.util.Map;

public class MapAccessExample {
  public static void main(String[] args) {
    Map<String, Object> map = new HashMap<>();
    map.put("name", "John");
    map.put("age", 30);
    map.put("city", "New York");

    System.out.println("Name: " + map.get("name"));
    System.out.println("Age: " + map.get("age"));
    System.out.println("City: " + map.get("city"));
  }
}
