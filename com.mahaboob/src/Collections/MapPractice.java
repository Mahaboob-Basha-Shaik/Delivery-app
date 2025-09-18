package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapPractice {
	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("Banana", 50);
		map.put("Apple", 10);
		map.put("Banana", 20);
		map.put("Cherry", 30);

		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}

	}	

}
