package lesson4.clonegood.otherpkg;

import lesson4.clonegood.MyDataClass;

public class CallingClass {
	@SuppressWarnings("unused")
	void myMethod(MyDataClass myData) {
		myData.setVal(5);
	}
	
	public static void main(String[] args) {
		CallingClass cc = new CallingClass();
		MyDataClass myData = new MyDataClass();
		cc.myMethod(myData);
		System.out.println(myData);
		
		myData.reset();
		
		try {
			MyDataClass copy = (MyDataClass)myData.clone();
			cc.myMethod(copy);
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(myData);
		
		
	}
}
