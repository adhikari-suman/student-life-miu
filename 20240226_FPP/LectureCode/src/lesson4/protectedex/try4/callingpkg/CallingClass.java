package lesson4.protectedex.try4.callingpkg;

import lesson4.protectedex.try4.objrefpkg.ObjRefClass;

public class CallingClass {
	public void methodCall(ObjRefClass cl){
		//ok now because the version of getVal()
		//is the overridden version in ObjRefClass
		String s = cl.getVal();
		
		
	}
}
