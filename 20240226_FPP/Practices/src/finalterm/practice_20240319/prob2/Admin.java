package finalterm.practice_20240319.prob2;

import java.util.*;

public class Admin {
	public static List<Student> convertArray(Object[] studentArray) {
		// Convert to ArrayList
		List<Student> students = new ArrayList<Student>();

		for (Object o : studentArray) {

			if (o instanceof Student) {
				students.add((Student) o);
			}

		}

		return students;
	}

	public static double computeAverageGpa(List<Student> studentList) {

		if(studentList == null || studentList.size()==0) {
			throw new IllegalArgumentException("Student list cannot be null or empty.");
		}
		
		double avgGPA = 0.0, totalGPA = 0.0;
		int numStudents = studentList.size();

		/* implement */
		for(Student std: studentList) {
			totalGPA +=std.computeGpa();
		}
		
		avgGPA = totalGPA/numStudents;
		
		return avgGPA;
	}
}
