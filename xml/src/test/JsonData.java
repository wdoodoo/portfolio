package test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonData {

	public static void main(String[] args) {
		JSONObject object = new JSONObject();
		JSONObject objsub = new JSONObject();
		JSONArray array = new JSONArray();
		objsub.put("name", "원두영");
		objsub.put("age", "30");
		objsub.put("블로그", "wdoodoo.com");
		
		array.add(objsub);
		array.add(objsub);
		object.put("Persons", array);
		object.put("Books", "");
		System.out.println(object);

	}

}
