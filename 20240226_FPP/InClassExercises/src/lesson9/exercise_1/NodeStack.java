package lesson9.exercise_1;

@SuppressWarnings("unused")
public class NodeStack {
	private Node top;

	public void push(String s) {
		// implement
		Node node = new Node();
		node.data = s;

		node.next = top;
		top = node;

	}

	public String peek() {
		if (top == null)
			return null;

		return top.data;
	}

	public String pop() {
		if (top == null)
			return null;

		String s = peek();

		top = top.next;

		return s;
	}

	public static void main(String[] args) {
		NodeStack stack = new NodeStack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println(stack.peek());
		System.out.println(stack.top.toString());
		System.out.println(stack.pop());
		System.out.println(stack.top.toString());

	}
}
