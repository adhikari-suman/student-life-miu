package lesson11.sets;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		String[] test = {"Tom", "Bob", "Heath", "Rich"};
		Set<String> strings = new HashSet<>();
		for(String s: test) {
			strings.add(s);
		}
		System.out.println(strings);
		strings.remove("Tom");
		System.out.println(strings);
		
		var stringsInOrder = new TreeSet<>();
		for(String s: test) {
			stringsInOrder.add(s);
		}
		System.out.println(stringsInOrder);


	}

}
