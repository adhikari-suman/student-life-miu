package lesson8.exercise_3;

public class SinglyLinkedList {
	private Node startNode;
	
	void insert(String s, int pos) {
		//implement
	}
	
	/** size = the number of non-null nodes */
	int size() {
		if(startNode == null) return 0;
		Node temp = startNode;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;	
	}
	
	boolean search(String s) {
		if(s == null) return false;
		Node next = startNode;
		while(next != null) {
			String t = next.data;
			if(s.equals(t)) {
				return true;
			}
			next = next.next;
		}
		return false;
	}
	void removeNode(String s) {
		if(s == null) return;
		if(startNode != null && startNode.data.equals(s)){
			startNode = startNode.next;
			return;
		}
		Node previous = startNode;
		Node next = startNode.next;
		while(next != null) {
			if(s.equals(next.data)) {
				previous.next = next.next;
				return;
			}
			previous = next;
			next = next.next;		
		}
	}
	
	void printNodes() {
		System.out.println(startNode.toString());
		System.out.println();
	}
	
	void addFirst(String s) {
		Node newNode = new Node();
		newNode.data = s;
		if(startNode != null) {
			newNode.next = startNode.next;
		}
		startNode = newNode;
	}
	
	void addLast(String s) {
		Node newNode = new Node();
		newNode.data = s;
		//if startNode == null, set startNode to be newNode
		if(startNode == null) {
			startNode = newNode;
		}
		else { //find last non-null node
			Node last = startNode;
			while(last.next != null) {
				last = last.next;
			}
			//now last is the last non-null node
			last.next = newNode;
			
		}		
	}
	
	class Node {
		String data;
		Node next;
		
		@Override
		public String toString() {
		    if(data == null) return "";
			StringBuilder sb = new StringBuilder(data + " ");
			sb = toString(sb, next);
			return sb.toString();
		}
		private StringBuilder toString(StringBuilder sb, Node n) {
			if(n == null) return sb;
			sb.append(n.data + " ");
			return toString(sb, n.next);
		}
	}	
	public static void main(String[] args) {
		
		SinglyLinkedList m = new SinglyLinkedList();
		m.populateNodes();
		boolean foundCharles = m.search("Charles");
		System.out.println("Found Charles? " + foundCharles);
		
		m.printNodes();
		m.addFirst("Frank");
		m.removeNode("David");
		m.printNodes();
		m.addLast("Ricardo");
		m.printNodes();
		
		//uncomment when ready
//		System.out.println(m.size());
//		m.insert("Bob", 2);
//		m.printNodes();
//		m.insert("Jerry", 5);
//		m.printNodes();
//		m.insert("Tom", 0);
//		m.printNodes();
//		m.insert("Jarred", 5);
//		m.printNodes();
		
	}
	private void populateNodes() {
		String[] stringData = {"Albert", "Billy", "Charles", "David", "Emma"};
		startNode = new Node();
		startNode.data = stringData[0];
		
		Node next = startNode;
		
		for(int i = 1; i < stringData.length; ++i) {
			next.next = new Node();
			next.next.data = stringData[i];
			next = next.next;
		}
	}
}
