package lesson3_20240229.exercise_1;

import java.util.Arrays;

public class Student {
	private String[] courses;
	private long id;
	private String name;
	private Program program;
	private int size;

	public Student(long i, String n) {
		id = i;
		name = n;

		size = 0;
		courses = new String[2];
		program = Program.COMPRO;
	}

	public Program getProgram() {
		return this.getProgram();
	}

	public void setProgram(Program p) {
		this.program = p;
	}

	public void addCourse(String course) {
		if (course == null) {
			return;
		}

		if (courses.length == size) {
			resize();
		}

		courses[size] = course;

		size++;
	}

	public boolean removeCourse(int index) {
		// Check if course doesn't exist
		if (courses == null || courses.length == 0) {
			return false;
		}
		
		if(index<0||index>=size) {
			return false;
		}

		// Create a new course
		String[] newCourses = new String[courses.length];

		// assign the course
		for (int i = 0, newCourseIndex = 0; i < courses.length && newCourseIndex < newCourses.length; i++) {
			if (i == index) {
				continue;
			}

			// fill the courses
			newCourses[newCourseIndex] = courses[i];
			newCourseIndex++;
		}

		
		/**
		 * Other approach using System.arraycopy()
		 */
//		System.arraycopy(courses, 0, newCourses, 0, index);
//		System.arraycopy(courses, index+1, newCourses, index, courses.length - (index+1)); // len = 5, index = 2  len - (index+1)
//		
		// set the course
		courses = newCourses;
		size--;
		
		// return flag
		return true;
	}

	void resize() {
		System.out.println("Resizing");

		// hold current courses in a temp array
		String[] oldCourses = courses;

		// Create a new array
		courses = new String[courses.length * 2];

		// Copy the array
		System.arraycopy(oldCourses, 0, courses, 0, oldCourses.length);
	}

	public String toString() {
		return String.format("{" + "  id: %d, \n" + "  name: %s, \n" + "  courses: %s, \n" + "  program:%s \n"
				+ "  size=%d \n" + "}", id, name, Arrays.toString(courses), program, size);
	}

}
