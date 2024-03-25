package lab09_20240315.prog1;

public class MyStringStack {
	private MyStringLinkedList list;

	public MyStringStack() {
		list = new MyStringLinkedList();
	}

	// O(1)
	public String pop() {
		// O(1)
		String str = peek();

		// list handles the index check by itself so no need
		// worst case O(n) but for this always will 
		// be O(1) since remove from head, so O(1)
		list.remove(0);
		
		return str;
	}

	public String peek() {

		return list.header.next == null ? null : list.header.next.value;

	}

	// Consider the top of the stack is the actual header ie.(header.next) of the stack
	public void push(String s) {
		list.insert(s, 0);
	}

	public static void main(String... args) {
		// Note: linked list head is considered the top of the stack 
		// for O(1) operation
		MyStringStack stack = new MyStringStack();
		stack.push("Bob");
		stack.push("Harry");
		stack.push("Alice");
		System.out.println("Popping…" + stack.pop());
		System.out.println("Peeking…." + stack.peek());
		System.out.println("Popping…" + stack.pop());
	}
}
