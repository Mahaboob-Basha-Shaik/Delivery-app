package Collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(3, "Banana");
		map.put(1, "Apple");
		map.put(4, "Mango");
		map.put(2, "Orange");
		map.put(5, "Banana");

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}
}
