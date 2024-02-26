package lesson10.bst;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 This implementation of a BST makes the following assumptions:
 1) Data stored in nodes are of type Integer
 2) No duplicate values are inserted. 
 */
public class MyBST {
	private Node root;
	

	//start with an empty tree
	public MyBST() {
		root = null;
	}
	/**
	 * Calls recursive find method to search
	 * for input Integer x; returns true if found,
	 * false otherwise. An iterative version
	 * can be built by modifying the insert
	 * method in this class.
	 * 
	 * @param x - Target Integer
	 * @return true if found, false otherwise
	 */
	public boolean find(Integer x) {
		if(x==null) return false;
		return find(x, root);
	}	
	
	/**
	 * Calls recursive find method to locate Node
	 * to be removed; then
	 * calls the recursive remove method to remove it.
	 * Returns true if target Node is found and
	 * is successfully removed, false otherwise
	 * 
	 * @param val - Integer to be removed
	 * @return true if found and removed, false otherwise
	 */
	public boolean remove(Integer val) {	
		Node node = findNode(val, root);
		return removeNode(node);	
	}
	
	/**
	 * Iterative implementation of insert operation
	 * (see slides for a recursive version). Note
	 * that this procedure assumes that client
	 * will not attempt to insert duplicate 
	 * values. If an attempt is made to insert a value
	 * already present in the tree, an IllegalArgumentException
	 * is thrown. 
	 * 
	 * @param x - Integer to be inserted
	 * @throws IllegalArgumentException if an attempt is made
	 * to insert a duplicate value.
	 */
	public void insert(Integer x) {
		if(find(x)) {
			return;
		}
		if (root == null) {
			root = new Node(x, null, null);
		}
		else {
			Node n = root;
			boolean inserted = false;
			while(!inserted) {
				//value x is smaller than node being examined -
				//go left unless left subtree is null, in which
				//case, insert data to the left
				if(x.compareTo(n.data)<0) {
					//space found on the left
					if(n.left == null){
						n.left = new Node(x,null,null);
						inserted = true;
					}
					//left subtree not null; move left
					else {
						n = n.left;
					}
				}
				//value x is greater than node being examined -
				//go right unless right subtree is null, in which
				//case, insert data to the right
				else if(x.compareTo(n.data)>0){ 
					//space found on the right					
					if(n.right==null){
						n.right = new Node(x,null,null);
						inserted = true;
					}
					else {
						n = n.right;
					}
				}
				//value x is equal to value found in node
				//--a duplicate value -- so
				//an exception is thrown
                else { 
                    throw new IllegalArgumentException(
                    	"Duplicate value passed in!");
           
                }	
			}
		}
	}	
	
	/**
	 * Calls recursive findMin method and returns
	 * the minimum value in the tree, or null if
	 * the tree is empty.
	 */
	public Integer findMin() {
		return findMin(root);
	}
	
	/**
	 * Prints the values in the nodes of the tree in sorted order.
	 * The work is done by the recursive printTree method.
	 * Printing is done by using an in-order traversal of the tree.
	 */
	public void printTree() {
		if (root == null)
			System.out.println("Empty tree");
		else
			printTree(root);
	}
	
	/**
	 * Prints to the console a visual representation of this
	 * tree, relying on the nested class BTreePrinter
	 */
	public void printAsDiagram() {
		BTreePrinter.printNode(root);
	}
	
	
	/**
	 * Reads the values in the tree following an
	 * in-order traversal and places them in a list.
	 * The work is done by the recursive asList method.
	 * 
	 * @return A list of all values in the tree in sorted order.
	 */
	public List<Integer> asList() {	
		return asList(new LinkedList<Integer>(), root);
	}
	
	///////// PRIVATE METHODS ///////////////

	private void printTree(Node t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.data);
			printTree(t.right);
		}
	}
	private List<Integer> asList(List<Integer> theList, Node t) {
		if(theList == null) return theList;
		if(t == null) return theList;
		if(t != null) {
			asList(theList, t.left);
			theList.add(t.data);
			asList(theList, t.right);
		}
		return theList;
	}
	private boolean removeNode(Node node) {
		if(node == null) return false;
		//in this case, we can just break the link
		//from node to its parent
		if(node.left == null && node.right== null) {
			Node parent = parent(node);
			if(parent != null) {
				if(parent.left == node) parent.left = null;
				if(parent.right == node) parent.right = null;
			}
			node = null;
			return true;
		}
		//in these cases, add a link from parent to 
		//child of node
		if(node.left != null && node.right == null ) {
			Node parent = parent(node);
			if(parent.left == node) parent.left = node.left;
			if(parent.right == node) parent.right = node.left;
			node = null;
			return true;
		}
		if(node.left == null && node.right != null ) {
			Node parent = parent(node);
			if(parent.left == node) parent.left = node.right;
			if(parent.right == node) parent.right = node.right;
			node = null;
			return true;
		}	
		
		//in this case, find min to the right of node and
		//insert this value into the node; link up parent of 
		//this min with right child of this min	
		if(node.left != null && node.right != null) {
			Node min = findMinNode(node.right);
			Node parentOfMin = parent(min);
			node.data = min.data;			
			parentOfMin.right = min.right;
			parentOfMin.left = null;
			return true;
		}
		return false;
	}
	private Node parent(Node t) {
		return parent(t,root,null);
	}
	private Node parent(Node t, Node n, Node parent) {
		if(n == null) return null;
		Integer val = t.data;
		if(n.data.equals(val)) return parent;
		if(val.compareTo(n.data)<0) {
			return parent(t,n.left, n);
		}
		else {
			return parent(t,n.right,n);
		}
	}
	private Node findNode(Integer val) {
		return findNode(val, root);
	}
	private Node findNode(Integer val, Node n) {
		if(n == null) return null;
		if(n != null && n.data.equals(val)) return n;
		if(val.compareTo(n.data) < 0) {
			return findNode(val, n.left);
		}
		else {
			return findNode(val, n.right);
		}
	}
	private Integer findMin(Node t) {
		Node s = findMinNode(t);
		return s.data;
	}
	
	private Node findMinNode(Node t) {
		if(t==null) return null;
		while(t.left != null) {
			t = t.left;
		}
		return t;
	}

	private boolean find(Integer x, Node n){
		if(n == null) return false;
		if(n != null && n.data.equals(x)) return true;
		return (x.compareTo(n.data) < 0) ?
				find(x, n.left) :
				find(x, n.right);
		
	}
	
	public static void main(String[] args){
		MyBST bst = new MyBST();
		bst.insert(1);
		bst.insert(20);
		bst.insert(15);
		bst.insert(6);
		bst.insert(7);
		//bst.insert(7);
		System.out.println(bst.asList());
	}

	class Node {
		private Integer data; // The data in the node
		private Node left; // Left child
		private Node right; // Right child
		
		Node(Integer theElement) {
			this(theElement, null, null);
		}
		Node(Integer element, Node left, Node right) {
			this.data = element;
			this.left = left;
			this.right = right;
		}
		public String toString() {
			return data.toString();
		}	
	}
	
	/**
	 * Specialized nested class to produce
	 * a visual image of this tree. This is
	 * third-party code. To access the functionality
	 * of this class, make a call to the static method
	 * printNode like this:  printNode(root)
	 *
	 */
	static class BTreePrinter {
	    public static void printNode(Node root) {
	        int maxLevel = BTreePrinter.maxLevel(root);
	        printNodeInternal(
	        	Collections.singletonList(root), 1, maxLevel);
	    }

	    @SuppressWarnings({ "rawtypes", "unchecked" })
		private static void printNodeInternal(List nodes, 
	    		int level, int maxLevel) {
	        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
	            return;
	        int floor = maxLevel - level;
	        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
	        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
	        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
	        BTreePrinter.printWhitespaces(firstSpaces);
	        List newNodes = new ArrayList();
	        for (Object node : nodes) {
	            if (node != null) {
	                System.out.print(((Node)node).data);
	                newNodes.add(((Node)node).left);
	                newNodes.add(((Node)node).right);
	            } else {
	                newNodes.add(null);
	                newNodes.add(null);
	                System.out.print(" ");
	            }

	            BTreePrinter.printWhitespaces(betweenSpaces);
	        }
	        System.out.println("");

	        for (int i = 1; i <= endgeLines; i++) {
	            for (int j = 0; j < nodes.size(); j++) {
	                BTreePrinter.printWhitespaces(firstSpaces - i);
	                if (nodes.get(j) == null) {
	                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
	                    continue;
	                }

	                if (((Node)nodes.get(j)).left != null)
	                    System.out.print("/");
	                else
	                    BTreePrinter.printWhitespaces(1);

	                BTreePrinter.printWhitespaces(i + i - 1);

	                if (((Node)nodes.get(j)).right != null)
	                    System.out.print("\\");
	                else
	                    BTreePrinter.printWhitespaces(1);

	                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
	            }

	            System.out.println("");
	        }

	        printNodeInternal(newNodes, level + 1, maxLevel);
	    }

	    static void printWhitespaces(int count) {
	        for (int i = 0; i < count; i++)
	            System.out.print(" ");
	    }

	    static int maxLevel(Node node) {
	        if (node == null)
	            return 0;

	        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
	    }

	    @SuppressWarnings("rawtypes")
		static boolean isAllElementsNull(List list) {
	        for (Object object : list) {
	            if (object != null)
	                return false;
	        }

	        return true;
	    }
	}
}