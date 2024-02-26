package lesson10.bst;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Provides a standard BST interface to Java's
 * TreeSet
 * @author pcorazza
 *
 */
public class MyJavaBST {
	private TreeSet<Integer> tree = new TreeSet<>();
	
	public void insert(Integer x) {
		tree.add(x);
	}
	
	public boolean remove(Integer x) {
		return tree.remove(x);
	}
	
	public boolean find(Integer x) {
		return tree.contains(x);
	}
	
	public List<Integer> asList() {
		return Arrays.asList(tree.toArray(new Integer[0]));		
	}
	
	public static void main(String[] args) {
		MyJavaBST bst = new MyJavaBST();
		System.out.println("Inserting 5, 7, 3, 9...");
		bst.insert(5); bst.insert(7); bst.insert(3); bst.insert(9);
		System.out.println(bst.asList());
		System.out.println("Removing 7");
		bst.remove(7);
		System.out.println(bst.asList());
		System.out.println("Is 5 in the tree? " + bst.find(5));
		System.out.println("Is 7 in the tree? " + bst.find(7));
	}

}
