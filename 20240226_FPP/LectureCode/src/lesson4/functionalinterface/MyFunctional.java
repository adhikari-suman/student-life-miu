package lesson4.functionalinterface;

@FunctionalInterface
public interface MyFunctional {
	void myMethod(String t);
	
	//if uncommented, there will be a compiler error
	//int anotherMethod(int x);
}
