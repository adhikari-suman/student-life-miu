package lesson12.exercise_2;

public class NodeStack {
	private Node top;	
	public void push(String s) {
		Node newTop = new Node();
		newTop.data = s;
		newTop.next = top;
		top = newTop;
	}
	public String peek() {
		if(top != null) {
			return top.data;
		}
		else {
			return null;
		}
	}
	public String pop() {
		if(top != null) {
			String s = peek();
			top = top.next;
			return s;
		
		} else {
			return null;
		}
	}
	
	public void printStack() {
		if(top == null) System.out.println("Empty stack");
		else System.out.println(top);
	}

	public static void main(String[] args) {
		NodeStack stack = new NodeStack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println(stack.peek());
		stack.printStack();
		System.out.println(stack.pop());
		stack.printStack();	
	}
}
