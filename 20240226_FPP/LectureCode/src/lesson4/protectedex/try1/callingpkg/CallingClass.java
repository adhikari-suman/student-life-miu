package lesson4.protectedex.try1.callingpkg;

import lesson4.protectedex.try1.objrefpkg.ObjRefClass;

public class CallingClass {
	public void methodCall(ObjRefClass cl){
		//obj ref class type is not same as or subclass
		//of CallingClass, and CallingClass is in diff
		//package from SuperClass -- compiler error
		
		//String s = cl.getVal();
		
		
	}
}
