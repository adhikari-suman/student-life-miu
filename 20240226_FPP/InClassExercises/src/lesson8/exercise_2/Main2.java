package lesson8.exercise_2;

public class Main2 {

	public static void main(String[] args) {
		//Single-node list
		Node startNode = new Node();
		startNode.data = "A";
		System.out.println(startNode);
		
		//Two-node list
		Node next = new Node();
		next.data = "B";
		startNode.next = next;
		System.out.println(startNode);
		
		//Three-node list -- add a node C to the list; (expected: A B C)
		     //implement
		Node C = new Node();
		C.data = "C";
		startNode.next.next = C;
		System.out.println(startNode);
		
		//Remove B from the list (expected output: A C)
		Node A = startNode;
		A.next = C;
		System.out.println(startNode);
		
		//Insert X into position 1  (expected output: A X C)
		Node X = new Node();
		X.data = "X";
		A.next = X;
		X.next = C;
		System.out.println(startNode);
		


	}

}
