package lesson8.node.full;



public class Main {
	
	String[] stringData = {"Albert", "Billy", "Charles", "David", "Emma"};
	public static void main(String[] args) {
		Main m = new Main();

		for(int i = 0; i < m.stringData.length; ++i) {
			m.add(m.stringData[i]);
		}
		m.printNodes();
		System.out.println("Is Charles in the list? " + m.search("Charles"));
		System.out.println("Is Bubba in the list? " + m.search("Bubba"));
		m.removeNode("Charles");
		m.printNodes();
		m.addFirst("Frank");
		m.removeNode("David");
		m.printNodes();
		m.add("Ricardo");
		m.printNodes();
		
//		Node n = m.find(2);
//		if(n == null) System.out.println("null");
//		else System.out.println(n.data);
		//m.remove(2);
		
	}
	
	
	
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
	Node startNode = null;
	void add(String s) {
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
	
	//exercise: implement Node find(int n)
	//exercise: implement String remove(int pos)

}
