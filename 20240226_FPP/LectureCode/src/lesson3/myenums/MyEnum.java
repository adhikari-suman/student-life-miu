package lesson3.myenums;

public class MyEnum {
	
	public static MyEnum FIRST = new First();
	public static MyEnum SECOND = new Second();
	public static MyEnum THIRD = new Third();
	private static class First extends MyEnum {}
	private static class Second extends MyEnum{}
	private static class Third extends MyEnum{}
}
