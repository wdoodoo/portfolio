package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class JacksonMapExample1 {
	public static void main(String[] args) {
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("1");
		hs.add("2");
		hs.add("2");
		System.out.println(hs.size());//3 이 아닌 2가 나오는것을 확인 --> 중복값이 허용 안됨을 확인
		
		
		
		
		
		
		/*
		 * HashMap jusorok = new HashMap(); jusorok.put("010-8888-8888", "원두영");
		 * jusorok.put("010-7777-7777", "제니"); System.out.println(jusorok);
		 * System.out.println(jusorok.values());
		 */
		
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"name\":\"mkyong\", \"age\":\"37\"}";
		try {
			// convert JSON string to Map
			Map<String, String> map = mapper.readValue(json, Map.class);
			// it works
			// Map<String, String> map = mapper.readValue(json, new
			// TypeReference<Map<String, String>>() {});
			System.out.println(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
