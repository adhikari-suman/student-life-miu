package lesson4.clone.shallowcopy;

//a change in the copy changes the original object
public class TheProblem {
	public static void main(String[] args) {
		Job joesjob = new Job(40, "Carpenter");
		Person joe = new Person("Joe", joesjob);
		System.out.println("Data about Joe:\n" + "  " + joe);
		try {
			Person joecopy = (Person) joe.clone();
			System.out.println("Data about Copy of Joe:\n" + "  " + joecopy);
			// modifies original object!
			joecopy.job.typeOfJob = "Painter";	
			System.out.println("Data about Joe after change to Copy of Joe:\n" + "  " + joe);
		} catch (CloneNotSupportedException e) {
			//handle
		}
	}

}
