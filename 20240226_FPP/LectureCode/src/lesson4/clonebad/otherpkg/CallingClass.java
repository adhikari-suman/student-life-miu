package lesson4.clonebad.otherpkg;

import lesson4.clonebad.MyDataClass;

public class CallingClass {
	void myMethod(MyDataClass cl) {
		//clone method not visible from here
		//even though MyDataClass and CallingClass
		//are subclasses of Object
        //MyDataClass copy = (MyDataClass)cl.clone();
	}
}


