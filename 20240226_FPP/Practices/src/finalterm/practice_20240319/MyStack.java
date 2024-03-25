package finalterm.practice_20240319;

public class MyStack {
	private Node top;

	private class Node {
		Integer data;
		Node next;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void push(Integer val) {
		Node t = new Node();
		t.data = val;

		if (!isEmpty()) {
			t.next = top;
		}

		top = t;

	}

	public Integer peek() {
		if (top == null) {
			throw new IllegalArgumentException("Cannot peek an empty stack.");
		}

		return top.data;
	}

	public Integer pop() {
		if (top == null) {
			throw new IllegalArgumentException("Cannot peek an empty stack.");
		}

		Node t = top;

		top = top.next;

		return t.data;

	}
}