package lesson3.myenums;



public abstract class MyEnum3 {
	public static MyEnum3 FIRST = new First(3);
	
	private static class First extends MyEnum3 {
		First(int x) {
			super(x);
		}
		public void modify() {
			val++;
		}
	}
	
	int val = 0;
	MyEnum3(int x) {
		this.val = x;
	}
	int val() {
		return val;
	}
	abstract public void modify();
	
}
