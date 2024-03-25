package lab09_20240315.prog3;

import java.util.Arrays;

public class ArrayQueueImpl {
	private int[] arr = new int[10];
	private int size = 0;
	private int front = -1;
	private int rear = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void enqueue(int n) {
		// check if rear has reached arr length, if yes resize
		if (rear == arr.length - 1) {
			resize();
		}

		/**
		 * Cases:
		 * 
		 * Case 1: front = -1, and rear = 0 Case 2: front == rear Case 3: front < rear
		 * Case 4: front > rear, illegal state Case 5: rear has reached arr.length - 1
		 */

		if (front == -1 && rear == 0) {
			arr[++front] = n;

		} else if (front <= rear) {
			arr[++rear] = n;
		} else { // front > rear, impossible case
			throw new IllegalStateException("Queue cannot have front > rear");
		}

		size++;

	}

	private void resize() {
		// Assign arr to temp array
		int[] tmpArr = arr;

		// Create a new array
		arr = new int[arr.length * 2];

		// Copy the elements
		System.arraycopy(tmpArr, front, arr, 0, size);

		// Automatically adjust front and rear
		front = 0;
		rear = size == 0 ? 0 : size - 1; // case could be front = rear = 9, and size would still be 0
	}

	public void dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Cannot dequeue because Queue is empty!");
		}

		/**
		 * Three cases: Case 1: front == rear Case 2: front < rear Case 3: front > rear
		 */
		if (front == rear) {
			front = 0;
			rear = 0;
		} else if (front < rear) {
			front++;
		} else { // front > rear, not possible
			throw new IllegalStateException("Queue cannot have front > rear");
		}

		size--;

	}

	public int peek() {
		if (isEmpty())
			throw new IllegalStateException("Cannot peek because Queue is empty!");

		return arr[front];
	}

	@Override
	public String toString() {

		int[] tmpArr = new int[size];
		System.arraycopy(arr, front, tmpArr, 0, size);

		String format = "*** Queue details ****\nfront: %-2d rear: %-2d size:%-2d \nArray: %s\nQueue: %s\n";

		return String.format(format, front, rear, size, Arrays.toString(arr), Arrays.toString(tmpArr));

	}

	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();

		// Note: Visual representation are added for better visualizing the queue
		// resizing and dequeue operations

		System.out.println("***************** Start - Queue Enqueue *****************\n\n");
		// uncomment when ready
		for (int i = 0; i < 15; i++) {
			q.enqueue(i);
			System.out.println(q);
		}

		System.out.println("***************** End - Queue Enqueue *****************\n\n");

		System.out.println("***************** Start - Queue Dequeue *****************\n\n");

		for (int i = 0; i < 14; i++) {
			q.dequeue();
			System.out.println(q);
		}

		System.out.println("***************** End - Queue Dequeue *****************\n\n");

		System.out.println(q.size());
		System.out.println(q.peek());
	}
}
