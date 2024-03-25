package lab09_20240315.prog4;

public class NodeQueue {
	/* stores the element at the front of the queue, if it exists */
	private Node head;

	/* stores the element at the end of the queue, if it exists */
	private Node tail;

	/**
	 * Inserts a new node containing s at end of queue
	 */
	public void enqueue(String s) {
		// implement
		/**
		 * Cases: Case 1: head == tail == null Case 2: head != tail
		 */
		Node node = new Node();
		node.data = s;

		if (isEmpty()) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	/**
	 * Removes node from the front of the queue and returns its value if head is n
	 */
	public String dequeue() throws QueueException {
		if (isEmpty())
			throw new QueueException("Queue is empty!");
		
		Node node = head;
		
		head = head.next;
		
		return node.data;
	}

	/**
	 * Returns value stored at the front of the queue
	 * 
	 * @return
	 * @throws QueueException
	 */
	public String peek() throws QueueException {
		if (isEmpty())
			throw new QueueException("Queue is empty!");
		return head.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "<empty queue>";
		return head.toString();
	}
}
