package lesson4.clonegood;

/**
 * Shows how a class is prepared so that it 
 * will support cloning.
 * 
 * Here two steps have been taken:
 * 1. Implement Cloneable
 * 2. Override Object's clone method using
 *    a public clone method.
 * 3. Callers must be prepared to handle CloneNotSupportedException
 *
 */
public class MyDataClass implements Cloneable {
	private int val = 1;
	public int getVal() {
		return val;
	}
	public void setVal(int y) {
		val = y;
	}
	//restores original value of val
	public void reset() {
		val = 1;
	}
	public MyDataClass clone() throws CloneNotSupportedException {
		return (MyDataClass)super.clone();
	}
	@Override
	public String toString() {
		return "" + val;
	}
}


