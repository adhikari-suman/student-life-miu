package lesson11.exercise_1;

public class MyClass {
	private int val;
	public MyClass(int x) {
		val = x;
	}
	public int getVal() {
		return val;
	}
	//implement
//	@Override
//	public int hashCode() {
//		
//	}
	@Override
	public String toString() {
		return "MyClass object #" + val;
	}
	public static void main(String[] args) {
		MyClass cl1 = new MyClass(1);
		MyHashtable hashtable = new MyHashtable();
		hashtable.put(cl1, 1);
	}
}
