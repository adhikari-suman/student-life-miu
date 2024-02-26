package lesson5_inner;

class MyOuterClass {
	MyInnerClass inner;
	private String param;

	MyOuterClass(String param) {
		inner = new MyInnerClass("innerStr");
		this.param = param; // the outer class version of this
	}

	void outerMethod() {
		System.out.println(inner.param);
		inner.innerMethod();
		//String t = inner.this.innerParam; //compiler error
		inner.innerMethod();
	}

	class MyInnerClass {
		private String param;

		MyInnerClass(String innerParam) {
			// the inner class version of 'this'
			this.param = innerParam;
		}

		void innerMethod() {
			// accessing enclosing class’s version of this
			System.out.println(MyOuterClass.this.param);

			// same as the following
			System.out.println(param);
		}
	}

	public static void main(String[] args) {
		MyOuterClass oc = new MyOuterClass("outerStr");
		oc.outerMethod();
		System.out.println(oc.param);
	}
}
