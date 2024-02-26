package lesson8.singlylinkedwithheader;

public class SinglyLinkedListWithHeader {
	Node header = null; //contains no data, cannot be removed
	
	public SinglyLinkedListWithHeader() {
		//header should never be null
		header = new Node();
	}
	boolean search(String s) {
		if(s == null) return false;
		//start node for searches is header.node
		Node next = header.next;
		while(next != null) {
			String t = next.data;
			if(s.equals(t)) {
				return true;
			}
			next = next.next;
		}
		return false;
	}
	
	void printNodes() {
		Node next = header.next;
		if(next == null) System.out.println("");
		else {
			String s= next.toString();
			System.out.println(s);
		}
	}
	
	void addFirst(String s) {
		Node newNode = new Node();
		newNode.data = s;
		
		//link from newNode to current header.node
		newNode.next = header.next;
		
		//link from header to newNode
		header.next = newNode;		
	}
	
	void addLast(String s) {
		Node newNode = new Node();
		newNode.data = s;
		Node last = header;
		while(last.next != null) {
			last = last.next;
		}
		//now last is the last non-null node
		last.next = newNode;		
	}
	void insert(String s, int pos) {
		int size = size();
		if(pos < 0 || pos > size) {
			throw new IllegalArgumentException(
				"Illegal position for new node");
		}
		if(pos == size) addLast(s); //same as add(s);
		else if(pos == 0) addFirst(s);
		else {
			Node n = new Node();
			n.data = s;
			if(header.next == null) header.next = n;
			else {
				Node temp = header.next;
				int count = 1; 
				while(count < pos) {
					temp = temp.next;
					count++;
				} 
				//insert n between temp and temp.node
				Node last = temp.next;
				temp.next = n;
				n.next = last;  //placing n into position pos
			}
		}
	}
	
	/** size = the number of non-null nodes */
	int size() {
		if(header.next == null) return 0;
		Node temp = header.next;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;	
	}
	
	void remove(String s) {
		if(s == null) return;
		Node next = header.next;
		Node previous = header;
		//if next == null, s cannot be removed
		while(next != null) {
			if(s.equals(next.data)) {
				previous.next = next.next;
				return;
			}
			previous = next;
			next = next.next;		
		}
	}
	
	/** Implement as inner class */
	private class Node {
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
		String[] stringData = {"Albert", "Billy", "Charles", "David", "Emma"};
		SinglyLinkedListWithHeader sll = new SinglyLinkedListWithHeader();
		//populate
		for(int i = stringData.length -1; i >= 0; i--) {
			sll.addFirst(stringData[i]);
		}
		boolean foundCharles = sll.search("Charles");
		System.out.println("Found Charles? " + foundCharles);
		
		sll.printNodes();
		sll.addFirst("Frank");
		sll.remove("David");
		sll.printNodes();
		sll.addLast("Francesca");
		sll.printNodes();
		System.out.println(sll.size());
		sll.insert("Becky", 0);
		sll.printNodes();
		sll.insert("Bobby", sll.size());
		sll.printNodes();
		sll.insert("Bubba", sll.size()-1);
		sll.printNodes();
	}
}


