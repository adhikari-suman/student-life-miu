package lesson8.node.full;

public class MainSoln {
	
	String[] stringData = {"Albert", "Billy", "Charles", "David", "Emma"};
	public static void main(String[] args) {
		MainSoln m = new MainSoln();
		m.populateNodes();
		m.printNodes();
		m.addLast("Last");
		m.printNodes();
//		m.addLastRecur("Last2");
//		m.printNodes();
		
		
//		boolean foundCharles = m.search("Charles");
//		System.out.println("Found Charles? " + foundCharles);
//		
//		m.printNodes();
		
		m.removeNode("David");
		m.printNodes();
		
		
//		m.addFirst("Frank");
//		m.printNodes();
//		
//		m.insert("Bob", 2);
//		m.printNodes();
//		m.insert("Jerry", 5);
//		m.printNodes();
//		m.insert("Tom", 0);
//		m.printNodes();

//		m.addLast("Ricardo");
//		m.printNodes();
//		
//		Node n = m.find(2);
//		if(n == null) System.out.println("null");
//		else System.out.println(n.data);
//		System.out.println(m.remove(2));
//		m.printNodes();
//		
//		System.out.println(m.size());
//		m.insert("Bob", 2);
//		m.printNodes();
//		m.insert("Jerry", 5);
//		m.printNodes();
//		m.insert("Tom", 0);
//		m.printNodes();
//		m.insert("Jarred", 5);
//		m.printNodes();
//		m.addLastRecur("Mohammed");
//		m.printNodes();
		
	}
	
	private Node startNode = null;
	
	void populateNodes() {
		
		startNode = new Node();
		startNode.data = stringData[0];
		
		Node next = startNode;
		
		for(int i = 1; i < stringData.length; ++i) {
			next.next = new Node();
			next.next.data = stringData[i];
			next = next.next;
		}
	}
	
	public boolean search(String s) {
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
	
	public void printNodes() {
		System.out.println(startNode.toString());
		System.out.println();
	}
	
	public void addFirst(String s) {
		Node newNode = new Node();
		newNode.data = s;
		newNode.next = startNode;
		startNode = newNode;
	}
	
	//Another name for the add method
	public void addLast(String s) {
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
	public void addLastRecur(String s) {
		Node newNode = new Node();
		newNode.data = s;
		if(startNode == null){
			startNode = newNode;
		} else {
			addLastRecur(startNode, newNode);
		}
	}
	
	private void addLastRecur(Node startFrom, Node newNode) {
		if(startFrom.next == null) { 
			startFrom.next = newNode;
		} else {
			addLastRecur(startFrom.next, newNode);
		}		
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
			//startNode will not be null at this point
			Node temp = startNode;
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
	/** Removes node containing input string s and returns true, if found
	 *  Otherwise, returns false.
	 */
	boolean removeNode(String s) {
		if(s == null || startNode == null) return true;
		if(startNode.data.equals(s)){
			startNode = startNode.next;
			return true;
		}
		Node previous = startNode;
		Node next = startNode.next;
		while(next != null) {
			if(s.equals(next.data)) {
				previous.next = next.next;
				return true;
			}
			previous = next;
			next = next.next;		
		}
		//String s not found, return false
		return false;
	}
	
	//exercise: implement Node find(int n) - returns null if n< 0 or no node in that pos
	Node find(int n) {
		if(n < 0) return null;
		Node next = startNode;
		for(int i = 0; i < n; ++i) {
			if(next.next != null) {
				next = next.next;
			}
			else return null;
			 
		}
		return next;
		
	}
	//exercise: implement String remove(int pos)
	String remove(int pos) {
		if(startNode == null) return null;
		String retval = null;
		if(pos == 0) {
			retval = startNode.data;
			startNode = startNode.next;
		} else {
			Node theNode = find(pos);
			Node previous = find(pos-1);
			if(theNode == null) return null;
			retval = theNode.data;
			if(theNode.next !=null) {
				previous.next = theNode.next;
			}
			
		}
		return retval;
		
	}

}
