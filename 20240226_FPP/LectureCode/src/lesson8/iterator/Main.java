package lesson8.iterator;

import java.util.*;

/** Illustrates two uses for Iterator */
public class Main {
	public static void main(String[] args) {
		directUseOfIterator();
		usingForEachConstruct();
	}
	
	public static void directUseOfIterator() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next());
		}
		System.out.println(sb);
	}
	public static void usingForEachConstruct() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		StringBuilder sb = new StringBuilder();
		//implicit use of Iterator
		for(String s: list) {
			sb.append(s);
		}
		System.out.println(sb);
	}
}
