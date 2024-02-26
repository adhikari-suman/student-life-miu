package lesson4.protectedex.try3.superpkg;

import lesson4.protectedex.try3.objrefpkg.ObjRefClass;

public class CallingClass {
	public void methodCall(ObjRefClass cl){
		//ok in this case because CallingClass is
		//in the same package as SuperClass		
		String s = cl.getVal();
	}
}
