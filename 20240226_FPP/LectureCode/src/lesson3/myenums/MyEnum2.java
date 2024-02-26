package lesson3.myenums;



public abstract class MyEnum2 {
	public static MyEnum2 FIRST = new First(3);
	
	private static class First extends MyEnum2 {
		First(int x) {
			super(x);
		}
		public void modify() {
			val++;
		}
	}
	
	int val = 0;
	MyEnum2(int x) {
		this.val = x;
	}
	int val() {
		return val;
	}
	abstract public void modify();
	
}
