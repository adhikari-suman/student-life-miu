package lesson5_singletons;

/** Developed by the creators of Spring */
public class SingletonAsInnerClass {

	static {
		System.out.println("static block");
	}

	private static class MySingletonHolder {

		static SingletonAsInnerClass instance = new SingletonAsInnerClass();
	}

	private SingletonAsInnerClass() {
		System.out.println("constructing now...");
	}

	public static SingletonAsInnerClass getInstance() {
		System.out.println("call to getInstance()");
		return MySingletonHolder.instance;
	}

	public static void main(String[] args) {
		System.out.println("Main method first call");
		// comment out and you see the instance is not created
		SingletonAsInnerClass.getInstance();
	}

}
