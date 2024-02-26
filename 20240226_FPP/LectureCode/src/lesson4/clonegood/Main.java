package lesson4.clonegood;

public class Main {

	public static void main(String[] args) {
		try {
			MyDataClass mdc = new MyDataClass();
			MyDataClass mdcCopy = mdc.clone();
			mdc.setVal(3);
			mdcCopy.setVal(5);
			System.out.println("Val in original: " + mdc.getVal());
			System.out.println("Val in copy: " + mdcCopy.getVal());
		} catch(CloneNotSupportedException e) {
			System.out.println("Can't clone");
		}
		
	}

}
