package lab05_20240305.prog1;

public class MySingleton {
	
	private int a;
	
	private static MySingleton instance;
	
	static {
		instance = new MySingleton();
	}
	
	private MySingleton() {
		a = 0;
	}
	
	
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}



	public static MySingleton getInstance() {
		return instance;
	}
}
