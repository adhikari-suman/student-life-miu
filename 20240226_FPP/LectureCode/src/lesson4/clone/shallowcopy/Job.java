package lesson4.clone.shallowcopy;

public class Job implements Cloneable {
	int numhours;
	String typeOfJob;
	public Job(int n, String t) {
		numhours = n;
		typeOfJob = t;
	}
	@Override
	public Job clone() throws CloneNotSupportedException {
		//shallow copy is fine here – variables are primitive or immutable
		return (Job)super.clone();
	}
	public String toString() {
		return typeOfJob + ": " + numhours;
	}
}
