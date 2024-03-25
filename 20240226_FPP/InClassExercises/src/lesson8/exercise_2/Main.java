package lesson8.exercise_2;

public class Main {

	public static void main(String[] args) {
		// Add A
		Node head = new Node();
		head.data = "A";
		System.out.println(head);

		// Add B
		Node b = new Node();
		b.data = "B";
		head.next = b;
		System.out.println(head);

		// Add C
		Node c = new Node();
		c.data = "C";
		b.next = c;
		System.out.println(head);

		// Remove B
		head.next = c;
		b.next = null;
		b = null;
		System.out.println(head);

		// Add X between A & C
		Node x = new Node();
		x.data = "X";
		head.next = x;
		
		x.next = c;
		
		c.next = null;
		System.out.println(head);

	}

}
