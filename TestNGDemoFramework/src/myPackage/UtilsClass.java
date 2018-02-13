package myPackage;

import java.util.HashMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UtilsClass {
	
	public static HashMap<String, String> getInputDataMap(HashMap<String, String> testDataMap) {
		HashMap<String, String> inputDataMap = new HashMap<String, String>();
		String jsonString = testDataMap.get("INPUTDATA");
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(jsonString);
		JsonObject jsonObject = je.getAsJsonObject();
		for(String key : jsonObject.keySet()) {
			String inputMapKey = key;
			String inputMapValue = jsonObject.get(key).getAsString();
			inputDataMap.put(inputMapKey, inputMapValue);
		}
		return inputDataMap;
	}

}
