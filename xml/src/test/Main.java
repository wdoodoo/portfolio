package test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException; 

public class Main { 
	public static void main(String[] args) { 
		String jsonData = "{\"Persons\":[{\"name\":\"고경태\",\"age\":\"30\",\"블로그\":\"ktko.tistory.com\",\"gender\":\"남자\"}, "
				+ "{\"name\":\"이홍준\",\"age\":\"31\",\"블로그\":\"없음\",\"gender\":\"남자\"},"
				+ "{\"name\":\"서정윤\",\"age\":\"30\",\"블로그\":\"없음\",\"gender\":\"여자\"}], \"Books\":[{\"name\":\"javascript의모든것\",\"price\":\"10000\"},{\"name\":\"java의모든것\",\"price\":\"15000\"}]}"; 
		try { 
			JSONParser jsonParse = new JSONParser(); //JSONParse에 json데이터를 넣어 파싱한 다음 JSONObject로 변환한다.
			JSONObject jsonObj = (JSONObject) jsonParse.parse(jsonData); //JSONObject에서 PersonsArray를 get하여 JSONArray에 저장한다. 
			JSONArray personArray = (JSONArray) jsonObj.get("Persons"); 
			for(int i=0; i < personArray.size(); i++) { 
				System.out.println("======== Person : " + i + " ========"); 
				JSONObject personObject = (JSONObject) personArray.get(i); 
				System.out.println(personObject.get("name")); 
				System.out.println(personObject.get("age"));
				System.out.println(personObject.get("블로그"));
			} 
			JSONArray booksArray = (JSONArray) jsonObj.get("Books"); 
			for(int i=0; i < booksArray.size(); i++) { 
				System.out.println("======== Books : " + i + " ========"); 
				JSONObject bookObject = (JSONObject) booksArray.get(i); 
				System.out.println(bookObject.get("name")); 
				System.out.println(bookObject.get("price")); 
				} 
			} catch (ParseException e) { 
				e.printStackTrace(); 
				} 
		} 
	} 

