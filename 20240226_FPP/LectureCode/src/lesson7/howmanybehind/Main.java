package lesson7.howmanybehind;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("A");
		Person p2 = new Person("B");
		p1.behind = p2;
		Person p3 = new Person("C");
		p2.behind = p3;
		Person p4 = new Person("D");
		p3.behind = p4;
		Person[] persons = {p1,p2,p3,p4};
		PersonLine pl = new PersonLine(persons);
		System.out.println(pl.howManyInLine());

	}

}
