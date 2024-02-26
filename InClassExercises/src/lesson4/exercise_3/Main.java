package lesson4.exercise_3;

import java.lang.reflect.InvocationTargetException;

public class Main {
	public static void main(String[] args) 
			throws ClassNotFoundException, InstantiationException, 
			   IllegalAccessException, IllegalArgumentException, 
			   InvocationTargetException, NoSuchMethodException, 
			   SecurityException {
				
		String className = "lesson4.exercise_3.Employee";
		Class<?> empClass = Class.forName(className);
		Employee emp = (Employee)empClass.getDeclaredConstructor().newInstance();
		
		emp.setName("Bob");
		emp.setSalary(85000);
		System.out.println(emp);
	}
}


