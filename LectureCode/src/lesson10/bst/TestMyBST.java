package lesson10.bst;

public class TestMyBST {

	public static void main(String[] args) {
		//testInsert();
		testRemove();
	}
	
	public static void testInsert() {
		System.out.println("Inserting  4, 6, 3, 1, 5");
		MyBST bst = new MyBST();
		bst.insert(4);
		bst.insert(6);
		bst.insert(3);
		bst.insert(1);
		bst.insert(5);
		System.out.print("As list: " + bst.asList());
		System.out.println("\nVisual:");
		bst.printAsDiagram();
	}
	
	public static void testRemove() {
		System.out.println("Inserting  4, 6, 3, 1, 5, 10, 7");
		MyBST bst = new MyBST();
		bst.insert(4);
		bst.insert(6);
		bst.insert(3);
		bst.insert(1);
		bst.insert(5);
		bst.insert(10);
		bst.insert(7);
		System.out.print("As list: " + bst.asList());
		System.out.println("\nVisual:");
		bst.printAsDiagram();
		System.out.println("Removing 6, which has two children");
		bst.remove(6);
		System.out.print("As list: " + bst.asList());
		System.out.println("\nVisual:");
		bst.printAsDiagram();
	}

}
