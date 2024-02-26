package lesson7.howmanybehind;

public class Person {
	private String name;
	Person behind;
	public Person(String n) {
		name = n;
	}
	public int answerToQuestion() {
		if(behind == null) return 0;
		return behind.answerToQuestion() + 1;
	}
}
