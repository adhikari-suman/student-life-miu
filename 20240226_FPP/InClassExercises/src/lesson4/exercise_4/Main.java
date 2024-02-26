package lesson4.exercise_4;

public class Main {
	public static void main(String[] args) {
		//testEquals1();
		testEquals2();
		//test();
	}
	private static void testEquals1() {
		Employee e1 = new Employee("Bob", 85000);
		Employee e2 = new Employee("Bob", 85000);
		System.out.println("Are e1 and e2 equal? " + e1.equals(e2));
	}
	private static void testEquals2() {
		Employee[] arr = new Employee[3];
		arr[0] = new Employee("Bob", 85000);
		arr[1] = new Employee("Steve", 95000);
		arr[2] = new Employee("Dave", 105000);
		Employee bob = new Employee("Bob", 85000);
		System.out.println("Is bob in the array? " 
		    + objectInArray(arr, bob));
	}
	private static boolean objectInArray(Object[] arr, Object b) {
		for(Object e: arr) {
			if(e.equals(b)) return true;
		}
		return false;
	}
	private static void test() {
		String[] arr = {"Bob", "Joe"};
		String s = "Bob";
		System.out.println("Does Bob belong to the array? " + 
		    objectInArray(arr, s));
		
	}
}
