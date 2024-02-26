 package lesson5_singletons;

/**
 * Not a thread-safe implementation.
 * Lazy initialization
 */
public class SingleThreadedSingleton {
	public static int count = 0;
	private static SingleThreadedSingleton instance;
	private SingleThreadedSingleton() {
		count++;
	}
	
	public static SingleThreadedSingleton getInstance() {
		if(instance == null) {
			instance = new SingleThreadedSingleton();
		}
		return instance;
	}
	
	public static void main(String[] args) {
//		SingleThreadedSingleton singleton = 
//			SingleThreadedSingleton.getInstance();
		for(int i = 0; i < 10; ++i) {
			SingleThreadedSingleton.getInstance();
		}
		System.out.println(count);
	}

}
