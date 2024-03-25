package lab08_20240313.prog2;

public class MyStringLinkedList {
	Node header;

	MyStringLinkedList() {
		header = new Node(null);
	}

	// adds to the front of the list
	public void addFirst(String item) {
		Node n = new Node(item);
		// place new node after header and
		// establish links from new node to
		// surrounding nodes
		n.next = header.next;
		n.previous = header;

		// establish links from surrounding
		// nodes to the new node
		if (header.next != null) {
			header.next.previous = n;
		}
		header.next = n;
	}

	// adds to the end of the list
	public void addLast(String item) {
		Node n = new Node(item);
		// find last node
		Node last = header;
		while (last.next != null) {
			last = last.next;
		}
		// now last.next == null
		last.next = n;
		n.previous = last;
	}

	// removes node in last position
	public void removeLast() {
		// if list is empty, return
		if (header.next == null)
			return;

		Node current = header;
		// traverse the list until current.next is
		// null - then remove current
		while (current.next != null) {
			current = current.next;
		}
		// now current.next == null, so remove current
		Node previous = current.previous;
		// previous is not null since current is not header
		previous.next = null;
		current.previous = null;
	}

	// determines whether the input string is in the list
	public boolean search(String s) {
		Node next = header.next;
		while (next != null && !next.value.equals(s)) {
			next = next.next;
		}
		// either next == null or next.value is s
		if (next == null)
			return false;
		else {// next.value.equals(s)
			return true;
		}
	}

	public Node itemAt(int index) {
		Node node = header;
		int pos = 0;

		while (pos != index && node != null) {
			node = node.next;
			pos++;
		}

		return node;

	}

	// inserts a new Node containing data so that its
	// position in the list is now
	// pos
	void insert(String data, int pos) {
		int currentPos = 0;
		Node node = header.next;

		// get the node behind the pos
		/// null -> A -> B -> C
		// insertAt -2
		// A -> D -> B -> C
		while (currentPos != pos - 1 && node != null) {
			node = node.next;
			currentPos++;
		}

		if (node == null)
			return;

		Node newNode = new Node(data);

		newNode.next = node.next;
		newNode.previous = node;

		node.next.previous = newNode;
		node.next = newNode;

	}

	// attempts to remove the first Node
	// that contains
	// data; if successful, returns true; otherwise, false.
	boolean remove(String data) {
		// null -> null
		Node node = header.next; //null

		while (node != null && !node.value.equals(data)) {
			node = node.next;
		}

		if (node == null) { // node == null
			return false;
		} else { 
			
			// A <-> B <-> C <-> null
			// remove(B)
			// node = B
			// result: // A <-> C <-> null
			
			// prevNode = A
			// nextNode = C
			Node prevNode = node.previous;
			Node nextNode = node.next;
			
			if(nextNode!=null) {
				nextNode.previous = prevNode; //A
			}
			
			prevNode.next = nextNode; // C
			
			node = null;

			return true;
		}

	}

	public String toString() {
		var sb = new StringBuffer();
		Node next = header.next;
		while (next != null) {
			sb.append(next.toString() + ", ");
			next = next.next;
		}
		var result = sb.toString().trim();
		if (result.length() == 0)
			return "<empty list>";
		if (result.charAt(result.length() - 1) == ',') {
			return result.substring(0, result.length() - 1);
		}
		return result;
	}
	
	public String toStringDescriptive() {
		var sb = new StringBuilder();
		Node next = header.next;
		while (next != null) {
			sb.append(next.toStringDescriptive() + " ");
			next = next.next;
		}
		var result = sb.toString().trim();
		if (result.length() == 0)
			return "<empty list>";
		if (result.charAt(result.length() - 1) == ',') {
			return result.substring(0, result.length() - 1);
		}
		return result;
	}

	public void minSort() {
//		if(arr == null || arr.length <=1) return;
//		int len = arr.length;
//		int temp = 0;
//		for(int i = 0; i < len; ++i){
//			int nextMinPos = minpos(i,len-1);
//			swap(i,nextMinPos); 
//		}

		if (header == null || header.next == null)
			return;

		Node currentNode = header.next;

		while (currentNode != null) {
			Node minNode = minNode(currentNode);

			if (minNode != null) {
				// swap
				swap(currentNode, minNode);
			}

			// set current node to the minNode.next
			currentNode = currentNode.next;
		}

	}

	void swap(Node n1, Node n2) {
		
		if(n1==null || n2==null)
			return;
		
		String temp = n1.value;
		n1.value = n2.value;
		n2.value = temp;
		
	}

	Node minNode(Node n) {
		if (n == null || n.next == null)
			return n;

		Node nextNode = n.next;

		Node minNode = n;

		while (nextNode != null) {
			int result = nextNode.value.compareTo(minNode.value);

			if (result <= 0) {
				minNode = nextNode;
			}

			nextNode = nextNode.next;
		}

		return minNode;
	}

	class Node {
		String value;
		Node next;
		Node previous;

		Node(String value) {
			this.value = value;
		}

		public String toString() {
			return value == null ? "null" : value;
		}

		public String toStringDescriptive() {
			return String.format("[%s|%s|%s]",previous == null ? "null" : previous.value, value, 
					next == null ? "null" : next.value);
		}
	}

	public static void main(String[] args) {
//		display1();
//
//		display2();
		
		display3();
	}

	public static void display3() {
		String[] testArr = { "big", "small", };
		MyStringLinkedList list = new MyStringLinkedList();
		for (int i = 0; i < testArr.length; ++i) {
			list.addLast(testArr[i]);
		}

		System.out.println("\n\n");

		System.out.println("The list:");
		System.out.println(list.toString());
		
		list.insert("Ariel", -10);
		
		System.out.println("The list:");
		System.out.println(list.toString());
	}
	
	public static void display1() {
		var list = new MyStringLinkedList();
		list.addLast("Rich");
		System.out.println(list);
		list.remove("Rich");
		System.out.println(list);
		list.addFirst("Bob");
		list.addFirst("Harry");
		list.addFirst("Steve");
		System.out.println(list);
		list.remove("Harry");
		System.out.println(list);
		System.out.println(list.search("Harry"));
		System.out.println(list.search("Bob"));
		list.addLast("Tom");
		System.out.println(list);
	}

	public static void display2() {
		String[] testArr = { "big", "small", "tall", "short", "round", "square", "enormous", "tiny", "gargantuan",
				"lilliputian", "numberless", "none", "vast", "miniscule" };
		MyStringLinkedList list = new MyStringLinkedList();

		for (int i = 0; i < testArr.length; ++i) {
			list.addLast(testArr[i]);
		}

		System.out.println("\n\n");

		System.out.println("The list:");
		System.out.println(list.toString());

		list.minSort();
		System.out.println("The list in sorted order:");
		System.out.println(list.toString());
		System.out.println();
	}
}
