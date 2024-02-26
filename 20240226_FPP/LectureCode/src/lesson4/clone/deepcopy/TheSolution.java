package lesson4.clone.deepcopy;

public class TheSolution {

	public static void main(String[] args) {
		Job joesjob = new Job(40, "Carpenter");
		Person joe = new Person("Joe", joesjob);
		System.out.println(joe);
		try {
			Person joecopy = (Person) joe.clone();
			System.out.println(joecopy);
			// does not modify orig object!
			joecopy.job.typeOfJob = "Painter";
			System.out.println("Joe copy info: " + joecopy);
			System.out.println(joe);
		} catch (CloneNotSupportedException e) {
		}
	}
}
