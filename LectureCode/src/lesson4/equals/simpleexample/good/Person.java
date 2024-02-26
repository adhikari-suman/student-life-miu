package lesson4.equals.simpleexample.good;



class Person {
	private String name;
	Person(String n) {
		name = n;
	}
	
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof Person)) return false;
		Person p = (Person)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
	public static void main(String[] args) {
		Person joe1 = new Person("Joe");
		Person joe2 = new Person("Joe");
		System.out.println("Is it true that joe1.equals(joe2)? "
			+ joe1.equals(joe2));
	}

}

