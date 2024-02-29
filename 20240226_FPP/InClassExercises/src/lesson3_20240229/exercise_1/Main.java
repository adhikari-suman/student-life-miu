package lesson3_20240229.exercise_1;

public class Main {

	public static void main(String[] args) {
		Student stu1 = new Student(61, "Ariel");
		
		System.out.println(stu1);
		
		// Add a course
		stu1.addCourse("FPP");
		System.out.println(stu1);
		
		// Add two courses
		stu1.addCourse("MPP");
		stu1.addCourse("DBMS");
		System.out.println(stu1);
		
		// Add three courses
		stu1.addCourse("EA");
		stu1.addCourse("WAP");
		stu1.addCourse("MWA");
		System.out.println(stu1);
		
		// Remove a course
		stu1.removeCourse(2);
		System.out.println(stu1);
		
		// Set program
		stu1.setProgram(Program.MBA);
		System.out.println(stu1);
	}

}
