package Collections;

import java.util.*;

public class HashSetPractice {
	public static void main(String[] args) {

//		HashSet in Java

		Set<String> hashSet = new HashSet<>();
		hashSet.add("B");
		hashSet.add("A");
		hashSet.add("C");

//		❓ Do these sets allow duplicates?

		hashSet.add("B");
		hashSet.add("A");
		hashSet.add("C");

		System.out.println("HashSet: " + hashSet);

		System.out.println();

//		LinkedHashSet in Java

		Set<String> Set = new LinkedHashSet<>();
		Set.add("B");
		Set.add("A");
		Set.add("C");

//		❓ Do these sets allow duplicates?

		Set.add("B");
		Set.add("A");
		Set.add("C");

		System.out.println("LinkedHashSet: " + Set);

		System.out.println();

//		TreeSet in Java

		Set<String> treeSet = new TreeSet<>();
		treeSet.add("B");
		treeSet.add("A");
		treeSet.add("C");

//		❓ Do these sets allow duplicates?

		treeSet.add("B");
		treeSet.add("A");
		treeSet.add("C");

		System.out.println("treeSet: " + treeSet);

	}
}
