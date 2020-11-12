package test;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

//Map 을 String 으로 변환 그리고?
public class JacksonMapExample2 {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "mikoung");
		map.put("age", "37");
		
		JSONObject jobj = JsonUtil.getJsonStringFromMap(map);
		
		System.out.println(jobj);		
		
		/*
		 * try { // convert map to JSON string String json =
		 * mapper.writeValueAsString(map); System.out.println(json); // compact-print
		 * json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		 * System.out.println(json); // pretty-print } catch (JsonProcessingException e)
		 * { e.printStackTrace(); }
		 */
	}

}
