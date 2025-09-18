package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>();
		linkedMap.put("Banana", 40);
		linkedMap.put("Orange", 50);
		linkedMap.put("Apple", 60);
		linkedMap.put("Orange", 30);

		for (Map.Entry<String, Integer> entry : linkedMap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
