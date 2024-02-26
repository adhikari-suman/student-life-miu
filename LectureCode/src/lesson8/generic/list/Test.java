package lesson8.generic.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List list2 = new ArrayList();
		list2.add("mike");
		Integer i = (Integer) list2.get(0); //class cast exception, no compiler check


		List<String> list = new ArrayList<String>();
		list.add("Bob");
		list.add("Sally");
//		list.add(124); //compiler won’t allow this
		String name = list.get(0); // no downcast required
		// clumsy runtime exceptions are now replaced by compiler errors
//		Integer name2 = (Integer)list.get(0);
		// iterate using for each construct – no downcasting //needed
		for (String s : list) {
			// do something with s
		}
		// any class type can be used as a parameter
		List<Employee> empList = new LinkedList<Employee>();
		empList.add(new Employee("Bob", 40000, 1996, 12, 2));
		empList.add(new Employee("Dave", 50000, 2000, 11, 15));

		List<Integer> list4 = new ArrayList<>();
	 	list4.add(5);   //5 converted to Integer type

	}
}
