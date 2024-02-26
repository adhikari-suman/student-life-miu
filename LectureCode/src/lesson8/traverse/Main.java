package lesson8.traverse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("Bob");
		list.add("Steve");
		list.add("Susan");
		list.add("Mark");
		list.add("Dave");
	
		System.out.println("---------Using for loop-------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("---------Using Iterator-------");	
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("---------Using for each construct-------");
		for (String str : list) {
			System.out.println(str.toString());
		}
		
		System.out.println("---------Using java 8 forEach method-------");
		list.forEach(name -> System.out.println(name));
		list.forEach(x -> System.out.println(x));
	}

}
