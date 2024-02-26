package lesson8.node.small;

public class Main {

	public static void main(String[] args) {
		//Single-node list
		Node startNode = new Node();
		startNode.data = "A";
		System.out.println(startNode);
		
		//Two-node list
		Node next = new Node();
		next.data = "B";
		startNode.node = next;
		System.out.println(startNode);
		
		//Three-node list
		next = new Node();
		next.data = "C";
		startNode.node.node = next;
		System.out.println(startNode);
		
		//Remove B
		Node b = startNode.node;		
		     //then change link from startNode so it points to C
		Node c = startNode.node.node;
		startNode.node = c;
		b = null;
		System.out.println(startNode);
		
		//Insert X into position 1
		Node pos1 = startNode.node;
		Node x = new Node();
		x.data = "X";
		x.node = pos1;
		startNode.node = x;
		System.out.println(startNode);

	}

}
